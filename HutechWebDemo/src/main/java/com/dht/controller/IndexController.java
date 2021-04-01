/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controller;

import com.dht.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author duonghuuthanh
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private CategoryService categoryService;
    
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        return "index";
    }
}
