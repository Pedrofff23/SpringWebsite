package com.example.mavenspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Hello {
    @GetMapping("/error")
    public String erro() {
        return "error";
    }

    @GetMapping("/hello")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView("hello");  // nome do arquivo html a ser renderizado/exibido
        mv.addObject("nome", "Pedro!");
        return mv;  // o Spring vai renderizar o arquivo templates/hello.html
    }

    @GetMapping("/hello-model")
    public String hello(Model model) {
        model.addAttribute("nome", "Zezinho!");
        return "hello";  // o Spring vai renderizar o arquivo templates/hello.html
    }

    @GetMapping("/hello-servlet")
    public String hello(HttpServletRequest request) {
        request.setAttribute("nome", "Samuka");
        return "hello";  // o Spring vai renderizar o arquivo templates/hello.html
    }

}
