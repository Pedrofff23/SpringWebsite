package com.example.mavenspring.controllers;

import com.example.mavenspring.Repository.BancoRepository;
import com.example.mavenspring.dto.RequisicaoNovoBanco;
import com.example.mavenspring.model.Banco;
import com.example.mavenspring.model.StatusBanco;
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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bancos")
public class BancoController {

    @Autowired
    private BancoRepository bancoRepository;

//    @RequestMapping("")
//    public ModelAndView listar(Pageable pageable, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
//
//        Integer currentPage = page.orElse(0); //define por padrao a requisicao por pagina a defaunt sendo a pagina 0
//        Integer pageSize = size.orElse(20); //define o tamanho de cada pagina pelo numero de elementos.
//
//        //agora nao passa uma lista completa e sim apenas um pagina com os requisitos que queremos.
//        Page<Banco> pageBanco = this.bancoRepository.findAll(PageRequest.of(currentPage, pageSize));
//        ModelAndView mv = new ModelAndView("Banco/ListaBanco");
//        mv.addObject("bancos",pageBanco);
//
//        return mv;
//    }

    @GetMapping("")
    public ModelAndView banco(Pageable pageable,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size,
                              @RequestParam("filtro")Optional<String> filtro){

        int currentPage = page.orElse(0);
        int pageSize = size.orElse(20) ;
        String filter = filtro.orElse("");

        Page<Banco> lista  = this.bancoRepository.searchByFilter("%"+filter+"%",PageRequest.of(currentPage , pageSize));
        System.out.println("%"+filter+"%");

        ModelAndView modelAndView = new ModelAndView("Banco/ListaBanco");
        modelAndView.addObject("filtro", new String());
        modelAndView.addObject("bancos",lista);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView novo(RequisicaoNovoBanco requisicao){
        ModelAndView mv = new ModelAndView("Banco/new");
        mv.addObject("listaStatusBanco", StatusBanco.values());

        return mv;
    }

    @PostMapping("")
    public ModelAndView salvar(@Valid RequisicaoNovoBanco requisicao, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("Banco/new");
            mv.addObject("listaStatusBancoo", StatusBanco.values());

            return mv;
        }
        else {
            Banco banco =  requisicao.toBanco();
            this.bancoRepository.save(banco);

            return new ModelAndView("redirect:/bancos/" + banco.getId());
        }
    }

    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable Integer id){
        Optional<Banco> optional= this.bancoRepository.findById(id);

        if(optional.isPresent()){
            Banco banco = optional.get();

            ModelAndView mv = new ModelAndView("Banco/show");
            mv.addObject("banco", banco);

            return mv;
        }
        else {
            return this.retunrErrorBanco("SHOW ERROR: Banco #" + id + " não encontrado"); //POSSO FAZER UMA PAGINA DE ERRO MELHOR FICA A DICA
        }
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Integer id, RequisicaoNovoBanco requisicao){
        Optional<Banco> optional= this.bancoRepository.findById(id);

        if(optional.isPresent()){
            Banco banco = optional.get();
            requisicao.fromBanco(banco);

            ModelAndView mv = new ModelAndView("Banco/edit");
            mv.addObject("bancoId", banco.getId());

            return mv;
        }
        else {
            return this.retunrErrorBanco("EDIT ERROR: Banco #" + id + " não encontrado"); //POSSO FAZER UMA PAGINA DE ERRO MELHOR FICA A DICA
        }
    }

    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable Integer id,@Valid RequisicaoNovoBanco requisicao, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView mv = new ModelAndView("Banco/edit");
            mv.addObject("bancoId", id);
            mv.addObject("listaStatusBancoo", StatusBanco.values());
            return mv;
        }
        else {
            Optional<Banco> optional= this.bancoRepository.findById(id);

            if(optional.isPresent()){
                Banco banco = requisicao.toBanco(optional.get());
                this.bancoRepository.save(banco);

                return new ModelAndView("redirect:/bancos/" + banco.getId());
            }
            else {
                return this.retunrErrorBanco("UPDATE ERROR: Banco #" + id + " não encontrado");
            }
        }
    }

    @GetMapping("/{id}/delete")
    public ModelAndView excluir(@PathVariable Integer id){
        ModelAndView mv = new ModelAndView("redirect:/bancos");
        try{
            this.bancoRepository.deleteById(id);
            mv.addObject("mensagem", "Banco #" + id + " deletado com sucesso");
            mv.addObject("erro", false);
        }catch (EmptyResultDataAccessException e){
            mv = this.retunrErrorBanco("DELETE ERROR: Banco #" + id + " não encontrado");
        }
        return mv;
    }

    private ModelAndView retunrErrorBanco(String msg){
        ModelAndView mv = new ModelAndView("redirect:/bancos");
        mv.addObject("mensagem", msg);
        mv.addObject("erro", true);
        return mv;
    }
}