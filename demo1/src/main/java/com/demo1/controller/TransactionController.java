package com.demo1.controller;

import com.demo1.dto.TransactionDto;
import com.demo1.model.Transaction;
import com.demo1.service.ICustomerService;
import com.demo1.service.ITransactionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @Autowired
    private ICustomerService customerService;

//    @GetMapping
//    public String index(Model model) {
//        List<Transaction> transactionList = transactionService.findAll();
//        model.addAttribute("transactionList", transactionList);
//        return "index";
//    }

    @GetMapping("")
    public ModelAndView search(@RequestParam(value = "search",defaultValue = "") String search,
                               @RequestParam(defaultValue = "") String searchss) {
        List<Transaction> transactions = transactionService.findByNameContaining(search,searchss);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("transactionList", transactions);
        return modelAndView;
    }


    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("transactionDto", new TransactionDto());
        model.addAttribute("customerList", customerService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated TransactionDto transactionDto,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        new TransactionDto().validate(transactionDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Transaction transaction = new Transaction();
            BeanUtils.copyProperties(transactionDto, transaction);

            transactionService.save(transaction);
            redirectAttributes.addFlashAttribute("message", "Create OK!");
            model.addAttribute("transactionList", transactionService.findAll());
        }
        return "redirect:/transaction";
    }


    @GetMapping("/{id}/detail")
    public ModelAndView showDetail(@PathVariable String id) {
        Transaction transaction = transactionService.findById(id).get();
        return new ModelAndView("detail",
                "transaction", transactionService.findById(id).get());
    }
}
