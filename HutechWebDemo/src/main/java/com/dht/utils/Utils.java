/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.utils;

import com.dht.pojo.Cart;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author duonghuuthanh
 */
public class Utils {
    public static Map<String, BigDecimal> cartStats(Map<Integer, Cart> sessionCart) {
        Map<String, BigDecimal> re = new HashMap<>();
        
        if (sessionCart != null) {
            Collection<Cart> carts = sessionCart.values();
            BigDecimal totalAmount = new BigDecimal(0);
            int totalQuantity = 0;
            for (Cart c: carts){
                totalQuantity += c.getQuantity();
                totalAmount = totalAmount.add(c.getPrice()
                        .multiply(new BigDecimal(c.getQuantity())));
            }
            
            re.put("totalAmount", totalAmount);
            re.put("totalQuantity", new BigDecimal(totalQuantity));
        } else {
            re.put("totalAmount", new BigDecimal(0));
            re.put("totalQuantity", new BigDecimal(0));
        }
        
        
        
        
        return re;
    }
}
