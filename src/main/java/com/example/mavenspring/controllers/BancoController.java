package com.example.mavenspring.controllers;

import com.example.mavenspring.Repository.BancoRepository;
import com.example.mavenspring.dto.RequisicaoNovoBanco;
import com.example.mavenspring.model.Banco;
import com.example.mavenspring.model.StatusBanco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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

    @RequestMapping("")
    public ModelAndView listar(){
        List<Banco> bancos = this.bancoRepository.findAll();
        ModelAndView mv = new ModelAndView("Banco/ListaBanco");
        mv.addObject("bancos",bancos);

        return mv;
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
            return new ModelAndView("redirect:/bancos"); //POSSO FAZER UMA PAGINA DE ERRO MELHOR FICA A DICA
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
            return new ModelAndView("redirect:/bancos");  //POSSO FAZER UMA PAGINA DE ERRO MELHOR FICA A DICA
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
                return new ModelAndView("redirect:/bancos");  //POSSO FAZER UMA PAGINA DE ERRO MELHOR FICA A DICA
            }
        }
    }

    @GetMapping("/{id}/delete")
    public String excluir(@PathVariable Integer id){
        try{
            this.bancoRepository.deleteById(id);
            return "redirect:/bancos";
        }catch (EmptyResultDataAccessException e){
            return "redirect:/bancos";
        }
    }
}
