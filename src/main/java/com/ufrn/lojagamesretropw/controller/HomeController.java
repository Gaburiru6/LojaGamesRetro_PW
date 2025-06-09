package com.ufrn.lojagamesretropw.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
    @GetMapping("/index")
    public String getHomePage(Model model) {
        return "index";
    }
}
