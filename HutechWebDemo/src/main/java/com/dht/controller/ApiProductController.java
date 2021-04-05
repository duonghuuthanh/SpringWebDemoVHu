/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controller;

import com.dht.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author duonghuuthanh
 */
@RestController
public class ApiProductController {
    @Autowired
    private ProductService productService;
    
    @DeleteMapping("/product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void deletProduct(@PathVariable(name = "productId") int productId) {
        this.productService.deleteProduct(productId);
    }
}
