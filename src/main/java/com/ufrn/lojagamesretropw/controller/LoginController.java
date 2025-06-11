package com.ufrn.lojagamesretropw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        // Apenas retorna o nome do arquivo de template (login.html)
        // que o Thymeleaf irá renderizar.
        return "login";
    }
}