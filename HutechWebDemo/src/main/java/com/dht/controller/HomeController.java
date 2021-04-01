/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controller;

import com.dht.pojo.Category;
import com.dht.pojo.Product;
import com.dht.service.CategoryService;
import com.dht.service.ProductService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author duonghuuthanh
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
    }
    
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("products", this.productService.getProducts(""));
        return "home";
    }
    
    @RequestMapping("/{cateId}")
    public String getProduct(Model model, @PathVariable(name="cateId") int cateId) {
        model.addAttribute("products", this.categoryService.getCategoryById(cateId).getProducts());
        return "home";
    }
    
    @RequestMapping("/product")
    public String product(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("product", new Product());
        return "product";
    }
    
    @RequestMapping("/product/{productId}")
    public String product(Model model, 
            @PathVariable(name = "productId") int productId) {
        model.addAttribute("categories", this.categoryService.getCategories());
        model.addAttribute("product", this.productService.getProductById(productId));
        return "product";
    }
    
    @PostMapping("/add-product")
    public String addProduct(Model model,
            @ModelAttribute(value = "product") @Valid Product product,
            BindingResult result) {
        if (result.hasErrors()) {
            return "product";
        }
        
        if (!this.productService.addOrUpdateProduct(product)) {
            model.addAttribute("error_msg", "SOMETHING WRONG!!! PLEASE COME BACK LATER!");
            return "product";
        }
        
        return "redirect:/";
    }
    
//    @RequestMapping("/home/{msg}")
//    public String home2(Model model, 
//            @PathVariable(name = "msg") String m,
//            @RequestParam(name = "name") String name) {
//        model.addAttribute("message", m + " - " + name);
//        return "home";
//    }
//    
//    @RequestMapping(path="/cate", method = RequestMethod.POST)
//    public String home3(Model model, 
//            @ModelAttribute(value = "category") Category cate) {
//        model.addAttribute("message", String.format("%d - %s\n", 
//                cate.getId(), cate.getName()));
//        return "home";
//    }
}
