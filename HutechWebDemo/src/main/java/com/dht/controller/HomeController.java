/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controller;

import com.dht.pojo.Cart;
import com.dht.service.CategoryService;
import com.dht.service.ProductService;
import com.dht.utils.Utils;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public void addAttributes(Model model, HttpSession session) {
        model.addAttribute("categories", this.categoryService.getCategories());
        
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        model.addAttribute("cartStat", Utils.cartStats(cart));
    }
    
    @RequestMapping("/")
    public String home(Model model, 
            @RequestParam(name="kw", required = false) String kw,
            @RequestParam(name="cateId", required = false) String cateId) {
        if (cateId == null)
            model.addAttribute("products", this.productService.getProducts(kw));
        else
            model.addAttribute("products", this.categoryService
                    .getCategoryById(Integer.parseInt(cateId)).getProducts());
        return "home";
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
