/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controller;

import com.dht.pojo.Cart;
import com.dht.pojo.Product;
import com.dht.service.OrderService;
import com.dht.service.ProductService;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.PostActivate;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author duonghuuthanh
 */
@RestController
public class ApiCartController {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/api/cart/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public void addToCart(HttpSession session,
            @PathVariable(name = "productId") int productId) {
        Product p = this.productService.getProductById(productId);
        
        // Tao gio
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }
        
        // Kiem tra san pham trong gio
        if (cart.containsKey(productId) == true) {
            int quan = cart.get(productId).getQuantity();
            cart.get(productId).setQuantity(quan + 1);
        } else {
            cart.put(productId, 
                    new Cart(productId, p.getName(), 
                            p.getPrice(), 1));
        }
        
        session.setAttribute("cart", cart);
    }
    
    @PostMapping("/api/cart/")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveOrder(HttpSession session) {
        boolean rs = this.orderService.addOrder((Map<Integer, Cart>) session.getAttribute("cart"));
        if (rs == true)
            session.setAttribute("cart", null);
    }
}
