/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.repository.impl;

import com.dht.pojo.Cart;
import com.dht.pojo.Product;
import com.dht.pojo.SaleOrder;
import com.dht.pojo.SaleOrderDetails;
import com.dht.pojo.User;
import com.dht.repository.OrderRepository;
import com.dht.utils.Utils;
import java.math.BigDecimal;
import java.util.Map;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author duonghuuthanh
 */
@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean addOrder(Map<Integer, Cart> cart) {
        if (cart != null) {
            try {
                Session session = this.sessionFactory.getObject().getCurrentSession();

                Map<String, BigDecimal> stats = Utils.cartStats(cart);
//                session.getTransaction().begin();
                SaleOrder order = new SaleOrder();
                order.setAmount(stats.get("totalAmount"));
                order.setUser(session.get(User.class, 6));
                session.save(order);

                for (Cart c : cart.values()) {
                    SaleOrderDetails detail = new SaleOrderDetails();
                    detail.setQuantity(c.getQuantity());
                    detail.setUnitPrice(c.getPrice());
                    detail.setProduct(session.get(Product.class, c.getProductId()));
                    detail.setSaleOrder(order);
                    session.save(detail);
                }
//                session.getTransaction().commit();

                return true;
            } catch (HibernateException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

}
