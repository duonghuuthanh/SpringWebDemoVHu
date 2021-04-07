/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.repository;

import com.dht.pojo.Cart;
import java.util.Map;

/**
 *
 * @author duonghuuthanh
 */
public interface OrderRepository {
    boolean addOrder(Map<Integer, Cart> cart);
}
