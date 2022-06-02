package com.example.mavenspring.controllers;

import com.example.mavenspring.Repository.BancoRepository;
import com.example.mavenspring.dto.RequisicaoNovoBanco;
import com.example.mavenspring.model.Banco;
import com.example.mavenspring.model.StatusBanco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

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

            return new ModelAndView("redirect:/bancos");
        }
    }
}
