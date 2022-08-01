package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String index(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "/category";
    }

    @GetMapping("/create_category")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "/create_category";
    }

    @PostMapping("/save")
    public String save(Category category) {
        categoryService.save(category);
        return "redirect:/category";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/edit_category";
    }

    @PostMapping("/update")
    public String update(Category category) {
        categoryService.update(category.getId(), category);
        return "redirect:/category";
    }

    @GetMapping("/{id}/delete")
    private String delete(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "/delete_category";
    }

    @PostMapping("/delete")
    public String delete(Category category, RedirectAttributes redirect) {
        categoryService.remove(category.getId());
        redirect.addFlashAttribute("success", "Removed category successfully!");
        return "redirect:/category";
    }

}
