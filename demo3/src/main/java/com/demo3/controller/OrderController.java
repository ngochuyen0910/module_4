package com.demo3.controller;

import com.demo3.dto.OrderDto;
import com.demo3.model.Orders;
import com.demo3.service.IOrderService;
import com.demo3.service.IProductService;
import com.demo3.service.IProductTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/product")
public class OrderController {
    @Autowired
    private IProductService productService;

    @Autowired
    private IProductTypeService productTypeService;

    @Autowired
    private IOrderService orderService;

    @GetMapping("")
    public ModelAndView findAll(@PageableDefault(value = 3) Pageable pageable) {
        return new ModelAndView("index", "orderList", orderService.findAll(pageable));
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("orderDto", orderService.findById(id));
        model.addAttribute("productList", productService.findAll());
        model.addAttribute("productTypeList", productTypeService.findAll());
        return "edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("orderDto") OrderDto orderDto, BindingResult bindingResult, RedirectAttributes redirect , Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("productList", productService.findAll());
            model.addAttribute("productTypeList", productTypeService.findAll());
            return "edit";
        }

        Orders orders = new Orders();
        BeanUtils.copyProperties(orderDto, orders);
        orderService.save(orders);
        redirect.addFlashAttribute("success", "Update product successfully!");
        return "redirect:/product";
    }
}
