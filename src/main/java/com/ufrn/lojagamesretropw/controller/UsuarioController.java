package com.ufrn.lojagamesretropw.controller;

import com.ufrn.lojagamesretropw.domain.DomainUsuario;
import com.ufrn.lojagamesretropw.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/cadastrar-usuario")
    public String showCadastroForm(Model model) {
        model.addAttribute("usuario", new DomainUsuario());
        return "cadastro-usuario";
    }

    @PostMapping("/cadastrar-usuario")
    public String cadastrarUsuario(@ModelAttribute DomainUsuario usuario, RedirectAttributes redirectAttributes, Model model) {
        try {
            usuarioService.cadastrar(usuario);
            redirectAttributes.addFlashAttribute("success_message", "Cadastro realizado com sucesso! Faça o login.");
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error_message", e.getMessage());
            model.addAttribute("usuario", usuario); // Devolve o objeto para preencher o formulário novamente
            return "cadastro-usuario";
        }
    }
}