package com.ufrn.lojagamesretropw.controller;

import com.ufrn.lojagamesretropw.domain.DomainJogo;
import com.ufrn.lojagamesretropw.services.CarrinhoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {

    private final CarrinhoService carrinhoService;

    @Autowired
    public CarrinhoController(CarrinhoService carrinhoService) {
        this.carrinhoService = carrinhoService;
    }


    @GetMapping("/adicionar/{id}")
    public String adicionarAoCarrinho(@PathVariable("id") Long idJogo, HttpSession session) {
        carrinhoService.adicionarAoCarrinho(idJogo, session);
        // Redireciona o usuário de volta para a página inicial após adicionar
        return "redirect:/index";
    }


    @GetMapping("/carrinho")
    public String verCarrinho(HttpSession session, Model model) {
        List<DomainJogo> itensDoCarrinho = carrinhoService.getItensDoCarrinho(session);
        model.addAttribute("itensCarrinho", itensDoCarrinho);
        return "main";
    }
}