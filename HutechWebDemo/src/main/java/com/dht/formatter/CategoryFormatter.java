/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.formatter;

import com.dht.pojo.Category;
import com.dht.service.CategoryService;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

/**
 *
 * @author duonghuuthanh
 */
@Component
public class CategoryFormatter implements Formatter<Category> {
//    @Autowired
//    private CategoryService categoryService;
    
    @Override
    public String print(Category object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Category parse(String text, Locale locale) throws ParseException {
//        Category c = this.categoryService.getCategoryById(Integer.parseInt(text));
        Category c = new Category();
        c.setId(Integer.parseInt(text));
        return c;
    }
    
}
