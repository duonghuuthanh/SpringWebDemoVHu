/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.validator;

import com.dht.pojo.Product;
import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author duonghuuthanh
 */
@Component
public class WebValidator implements Validator {
    @Autowired
    private javax.validation.Validator beanValidators;
    private Set<Validator> springValidators = new HashSet<>();
    
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // Bean Validator
        Set<ConstraintViolation<Object>> validators = beanValidators.validate(target);
        for (ConstraintViolation<Object> obj: validators)
            errors.rejectValue(obj.getPropertyPath().toString(), 
                    obj.getMessageTemplate(), obj.getMessage());
            
        // Spring Validator
        for (Validator v: this.springValidators)
            v.validate(target, errors);
    }

    /**
     * @param springValidators the springValidators to set
     */
    public void setSpringValidators(Set<Validator> springValidators) {
        this.springValidators = springValidators;
    }
    
}
