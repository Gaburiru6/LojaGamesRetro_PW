package com.ufrn.lojagamesretropw.controller;

import com.ufrn.lojagamesretropw.domain.DomainJogo;
import com.ufrn.lojagamesretropw.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;

@Controller
public class Admincontroller {

    private final JogoService jogoService;

    @Autowired
    public Admincontroller(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping("/admin/cadastrar")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("jogo", new DomainJogo());

        return "cadastro";
    }

    @PostMapping("/admin/cadastrar")
    public String salvarJogo(@ModelAttribute DomainJogo jogo) {
        jogoService.save(jogo);

        return "redirect:/";
    }
}