package com.example.mavenspring.controllers;

import com.example.mavenspring.dto.RequisicaoNovoBanco;
import com.example.mavenspring.model.Banco;
import com.example.mavenspring.Repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/banco")
public class BancoController {
    //CRIA O OBJETO DO REPOSITORIO E ENJETA AUTOMATICAMENTE
    @Autowired
    private BancoRepository bancoRepository; //E SO O REPOSITORIO

    @RequestMapping("")
    public ModelAndView listar(){
        List<Banco> bancos = this.bancoRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("Banco/ListaBanco");
        modelAndView.addObject("bancos",bancos);
        return modelAndView;
    }
    @GetMapping("/new")
    public ModelAndView novo(){
        ModelAndView modelAndView = new ModelAndView("Banco/new");
        modelAndView.addObject("banco",new RequisicaoNovoBanco());
        return modelAndView;
    }
    //Dentro do parenteses quer dizer q passa o objeto(Banco) de uma classe(banco)
    @PostMapping("/new")
    public ModelAndView salvar(@Valid RequisicaoNovoBanco requisicao, BindingResult bindingResult) {
        if (bindingResult.hasErrors() ){
            ModelAndView modelAndView = new ModelAndView("Banco/new");
            modelAndView.addObject("banco",requisicao);
            return modelAndView;
        }
        else{
            Banco banco = requisicao.toBanco();
            this.bancoRepository.save(banco);
            return new ModelAndView("redirect:/banco");
        }
    }
}
