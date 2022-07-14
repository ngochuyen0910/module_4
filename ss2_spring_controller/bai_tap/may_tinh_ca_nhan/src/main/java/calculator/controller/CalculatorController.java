package calculator.controller;

import calculator.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("")
    public String home() {
        return "index";
    }

    @PostMapping("")
    public String result(String number1, String number2, String calculator, Model model) {
        String result = calculatorService.result(number1, number2, calculator);
        model.addAttribute("result", result);
        return "index";
    }
}
