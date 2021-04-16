/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controller;

import com.dht.service.OrderService;
import freemarker.template.SimpleDate;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author duonghuuthanh
 */
@Controller
public class OrderController {
    @Autowired
    private SimpleDateFormat simpleDateFormat;
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/stats")
    public String stats(Model model,
            @RequestParam(name = "fromDate", required = false) String fromDate,
             @RequestParam(name = "toDate", required = false) String toDate) {
        
        Date fr = null, to = null;
        try {
            fr = this.simpleDateFormat.parse(fromDate);
            to = this.simpleDateFormat.parse(toDate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        List<Object[]> dataStats = this.orderService.getOrderStats(fr, to);
        List<BigDecimal> amounts = new ArrayList<>();
        for (Object[] d: dataStats)
            amounts.add((BigDecimal) d[1]);
        
        
        model.addAttribute("dataStats", dataStats);
        model.addAttribute("amounts", amounts);
        
        return "stats";
    }
}
