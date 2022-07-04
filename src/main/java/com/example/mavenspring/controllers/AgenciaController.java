package com.example.mavenspring.controllers;

import com.example.mavenspring.Repository.AgenciaRepository;
import com.example.mavenspring.Repository.BancoRepository;
import com.example.mavenspring.dto.RequisicaoNovaAgencia;
import com.example.mavenspring.dto.RequisicaoNovoBanco;
import com.example.mavenspring.model.Banco;
import com.example.mavenspring.model.StatusAgencia;
import com.example.mavenspring.model.StatusBanco;
import com.example.mavenspring.model.agencia_bancaria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/agencia")
public class AgenciaController {

    @Autowired
    private AgenciaRepository agenciaRepository;

    @GetMapping("")
    public ModelAndView agencia(Pageable pageable,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size,
                              @RequestParam("filtro")Optional<String> filtro){

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(20) ;
        String filter = filtro.orElse("");

        Page<agencia_bancaria> lista  = this.agenciaRepository.findbyFilter("%"+filter+"%", PageRequest.of(currentPage , pageSize));
        System.out.println("%"+filter+"%");

        ModelAndView modelAndView = new ModelAndView("Agencia/ListaAgencia");
        modelAndView.addObject("filtro", new String());
        modelAndView.addObject("agencia_bancaria",lista);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView novo(RequisicaoNovaAgencia requisicao){
        ModelAndView mv = new ModelAndView("Agencia/new");
        mv.addObject("listaStatusAgencia", StatusAgencia.values());

        return mv;
    }

    @PostMapping("")
    public ModelAndView salvar(@Valid RequisicaoNovaAgencia requisicao, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("Agencia/new");
            mv.addObject("listaStatusAgencia", StatusAgencia.values());

            return mv;
        }
        else {
            agencia_bancaria agencia =  requisicao.toAgencia();
            this.agenciaRepository.save(agencia);

            return new ModelAndView("redirect:/agencia/" + agencia.getId());
        }
    }

    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable Integer id){
        Optional<agencia_bancaria> optional= this.agenciaRepository.findById(id);

        if(optional.isPresent()){
            agencia_bancaria agencia = optional.get();

            ModelAndView mv = new ModelAndView("Agencia/show");
            mv.addObject("agencia", agencia);

            return mv;
        }
        else {
            return this.retunrErrorAgencia("SHOW ERROR: Agencia #" + id + " não encontrada"); //POSSO FAZER UMA PAGINA DE ERRO MELHOR FICA A DICA
        }
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Integer id, RequisicaoNovaAgencia requisicao){
        Optional<agencia_bancaria> optional= this.agenciaRepository.findById(id);

        if(optional.isPresent()){
            agencia_bancaria agencia = optional.get();
            requisicao.fromAgencia(agencia);

            ModelAndView mv = new ModelAndView("Agencia/edit");
            mv.addObject("agenciaId", agencia.getId());

            return mv;
        }
        else {
            return this.retunrErrorAgencia("EDIT ERROR: Agencia #" + id + " não encontrada"); //POSSO FAZER UMA PAGINA DE ERRO MELHOR FICA A DICA
        }
    }

    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable Integer id,@Valid RequisicaoNovaAgencia requisicao, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("Agencia/edit");
            mv.addObject("agenciaId", id);
            mv.addObject("listaStatusAgencia", StatusAgencia.values());
            return mv;
        }
        else {
            Optional<agencia_bancaria> optional= this.agenciaRepository.findById(id);

            if(optional.isPresent()){
                agencia_bancaria agencia = requisicao.toAgencia(optional.get());
                this.agenciaRepository.save(agencia);

                return new ModelAndView("redirect:/agencia/" + agencia.getId());
            }
            else {
                return this.retunrErrorAgencia("UPDATE ERROR: Agencia #" + id + " não encontrada");
            }
        }
    }

    @GetMapping("/{id}/delete")
    public ModelAndView excluir(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView("redirect:/agencia");
        try{
            this.agenciaRepository.deleteById(id);
            mv.addObject("mensagem", "Agencia #" + id + " deletada com sucesso");
            mv.addObject("erro", false);
        }catch (EmptyResultDataAccessException e){
            mv = this.retunrErrorAgencia("DELETE ERROR: Agencia #" + id + " não encontrada");
        }
        return mv;
    }

    private ModelAndView retunrErrorAgencia(String msg){
        ModelAndView mv = new ModelAndView("redirect:/agencia");
        mv.addObject("mensagem", msg);
        mv.addObject("erro", true);
        return mv;
    }
}
