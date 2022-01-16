package com.ttl.web.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author: Moustafa.Bayoumy
 * @since: 1/16/2022 - 5:36 PM
 */
public class MatchValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
