package com.case_study.controller.customer;

import com.case_study.model.customer.CustomerType;
import com.case_study.service.customer_type.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("customer_type")
public class CustomerTypeController {
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    public String index(Model model) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        return "customer_type/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerTypeList", new CustomerType());
        return "customer_type/create";
    }

    @PostMapping("/save")
    public String save(CustomerType customerType) {
        customerTypeService.save(customerType);
        return "redirect:/customer_type";
    }
}
