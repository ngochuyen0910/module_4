package com.add_product_to_cart.controller;

import com.add_product_to_cart.dto.CartDto;
import com.add_product_to_cart.dto.ProductDto;
import com.add_product_to_cart.model.Product;
import com.add_product_to_cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@SessionAttributes("cart")
@Controller
@RequestMapping(value = "/shop")

public class ProductController {
    @Autowired
    IProductService productService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping
    public ModelAndView showListPage(Model model,
                                     @CookieValue(value = "idProduct",
                                             defaultValue = "-1") Long idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", productService.findById(idProduct).get());
        }
        return new ModelAndView("product/list", "productList", productService.findAll());
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable long id,
                                   HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(1 * 24 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);

        return new ModelAndView("product/detail",
                "product", productService.findById(id).get());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = productService.findById(id);
        if (productDetail.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productDetail.get(), productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cart) {
        Optional<Product> productDetail = productService.findById(id);
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(productDetail.get(),productDto);
        cart.remove(productDto);
        return "redirect:/cart";
    }
}