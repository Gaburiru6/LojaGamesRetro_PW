package com.ufrn.lojagamesretropw.controller;
import com.ufrn.lojagamesretropw.domain.DomainJogo;
import com.ufrn.lojagamesretropw.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class HomeController {

    private final JogoService jogoService;

    @Autowired
    public HomeController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    // NOVO MÉTODO: Redireciona da raiz para /index
    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }


    @GetMapping("/index")
    public String listarJogos(Model model) {
        List<DomainJogo> jogos = jogoService.findAllActive();
        model.addAttribute("Jogos", jogos);
        return "index";
    }
}