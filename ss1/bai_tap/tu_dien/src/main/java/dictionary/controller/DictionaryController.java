package dictionary.controller;

import dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("")
    public String home() {
        return "translate";
    }

    @PostMapping
    public String translate(@RequestParam String english, Model model) {
        String result = dictionaryService.value(english);
        model.addAttribute("result", result);
        return "translate";
    }
}
