package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichCondimentController {
    @GetMapping("")
    private String home() {
        return "index";
    }

    @GetMapping("/save")
    public String save(@RequestParam(value = "condiment", defaultValue = "") String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "index";
    }
}
