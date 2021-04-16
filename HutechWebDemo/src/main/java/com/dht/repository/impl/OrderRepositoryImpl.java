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
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

                return true;
            } catch (HibernateException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Override
    @Transactional
    public List<Object[]> getOrderStats(Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        Root orderRoot = query.from(SaleOrder.class);
        Root detailRoot = query.from(SaleOrderDetails.class);
        
        query = query.where(builder.equal(orderRoot.get("id"), detailRoot.get("saleOrder")));
        query.multiselect(orderRoot.get("id"), 
                orderRoot.get("amount").as(BigDecimal.class),
                orderRoot.get("createdDate").as(Date.class),
                builder.count(detailRoot.get("id")));
        query.groupBy(orderRoot.get("id"), 
                orderRoot.get("amount").as(BigDecimal.class),
                orderRoot.get("createdDate").as(Date.class));
        
        if (fromDate != null && toDate != null) {
            Predicate p1 = builder.greaterThanOrEqualTo(
                    orderRoot.get("createdDate").as(Date.class), fromDate);
            Predicate p2 = builder.lessThanOrEqualTo(
                    orderRoot.get("createdDate").as(Date.class), toDate);
            query = query.having(p1, p2);
        }
        
        Query q = session.createQuery(query);
        
        return q.getResultList();
    }

}
