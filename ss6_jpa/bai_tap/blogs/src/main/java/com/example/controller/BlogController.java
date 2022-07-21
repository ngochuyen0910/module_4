package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
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
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/a")
    public String index(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/index";
    }

    @GetMapping("")
    public ModelAndView findAll(@PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("index", "blogList", blogService.findAll(pageable));
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        //product.setId((int) (Math.random() * 10000));
        blogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        blogService.update(blog.getId(), blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    private String delete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        blogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed blog successfully!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public ModelAndView search(@RequestParam("search")
                                       String search, @PageableDefault(value = 1) Pageable pageable) {
        Page<Blog> blogs = blogService.findByNameContaining("%" + search + "%", pageable);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("blogList", blogs);
        return modelAndView;
    }
}
