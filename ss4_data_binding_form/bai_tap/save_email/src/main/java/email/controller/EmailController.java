package email.controller;

import email.model.Email;
import email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    private IEmailService emailService;

    @GetMapping("")
    public String showEmail(Model model) {
        List<Email> emailList = emailService.findAll();
        model.addAttribute("emailList", emailList);
        return "index";
    }

    @GetMapping("/update")
    public String home(@RequestParam int id, Model model) {
        model.addAttribute("email", emailService.findById(id));
        model.addAttribute("temps", emailService.findLanguage());
        model.addAttribute("temp", emailService.findPageSize());

        return "result";
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("email") Email email) {
        emailService.update(email);
        List<Email> emailList = emailService.findAll();
        ModelAndView modelAndView = new ModelAndView("index", "emailList", emailList);
        return modelAndView;
    }
}
