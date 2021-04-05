/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.validator;

import com.dht.pojo.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author duonghuuthanh
 */
@Component
public class DescriptionValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product p = (Product) target;
        if (p.getDescription() != null 
                && !p.getDescription().toLowerCase().contains(p.getName().toLowerCase()))
            errors.rejectValue("description", "product.description.err");
    }
}
