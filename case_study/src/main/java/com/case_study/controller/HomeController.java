package com.case_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showHome() {
        return "/home";
    }

    @GetMapping("/c0322g1")
    public String showLogin() {
        return "/login";
    }
}