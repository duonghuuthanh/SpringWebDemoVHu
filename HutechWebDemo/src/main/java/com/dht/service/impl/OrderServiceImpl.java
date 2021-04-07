/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.service.impl;

import com.dht.pojo.Cart;
import com.dht.repository.OrderRepository;
import com.dht.service.OrderService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author duonghuuthanh
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public boolean addOrder(Map<Integer, Cart> cart) {
        return this.orderRepository.addOrder(cart);
    }
    
}
