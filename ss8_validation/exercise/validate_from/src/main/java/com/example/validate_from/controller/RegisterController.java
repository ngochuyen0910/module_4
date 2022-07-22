package com.example.validate_from.controller;

import com.example.validate_from.dto.RegisterDto;
import com.example.validate_from.model.Register;
import com.example.validate_from.service.IRegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private IRegisterService registerService;

    @GetMapping("")
    public String index(Model model) {
        List<Register> registerList = registerService.findAll();
        model.addAttribute("registerList", registerList);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated RegisterDto registerDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        new RegisterDto().validate(registerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Register register = new Register();
            BeanUtils.copyProperties(registerDto, register);

            registerService.save(register);
            redirectAttributes.addFlashAttribute("message", "Create OK!");
            model.addAttribute("registerList", registerService.findAll());
        }
        return "redirect:/register";
    }
}
