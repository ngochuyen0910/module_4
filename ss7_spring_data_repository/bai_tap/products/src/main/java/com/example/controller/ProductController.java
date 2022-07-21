package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductManagementService productManagementService;

    @GetMapping("/a")
    public String index(Model model) {
        List<Product> productList = productManagementService.findAll();
        model.addAttribute("productList", productList);
        return "/index";
    }

    @GetMapping("")
    public ModelAndView findAll(@PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("index", "productList", productManagementService.findAll(pageable));
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        //product.setId((int) (Math.random() * 10000));
        productManagementService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", productManagementService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productManagementService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    private String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productManagementService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productManagementService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productManagementService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam("search")
                                       String search, @PageableDefault(value = 1) Pageable pageable) {
        Page<Product> products = productManagementService.findByNameContaining("%" + search + "%", pageable);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("productList", products);
        return modelAndView;
    }
}