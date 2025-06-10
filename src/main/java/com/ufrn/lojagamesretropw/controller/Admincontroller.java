package com.ufrn.lojagamesretropw.controller;

import com.ufrn.lojagamesretropw.domain.DomainJogo;
import com.ufrn.lojagamesretropw.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class Admincontroller {

    private final JogoService jogoService;

    @Autowired
    public Admincontroller(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping("/index")
    public String listarJogos(Model model) {
        List<DomainJogo> jogos = jogoService.findAll();
        model.addAttribute("Jogos", jogos);
        return "admin";
    }

    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("jogo", new DomainJogo());

        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String salvarJogo(@ModelAttribute DomainJogo jogo) {
        jogoService.save(jogo);

        return "redirect:/admin/index";
    }

    @GetMapping("/editar/{id}")
    public String exibirFormularioEdit(Model model, @PathVariable("id") Long id) {
        DomainJogo jogo = jogoService.findById(id).get();
        model.addAttribute("jogo", jogo);
        return "cadastro";
    }

    @PostMapping("/deletar/{id}")
    public String deletarJogo(@PathVariable("id") Long id) {
        jogoService.softDelete(id);

        return "redirect:/admin/index";
    }
}