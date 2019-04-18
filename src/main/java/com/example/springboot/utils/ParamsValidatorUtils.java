package com.example.springboot.utils;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


@Configuration
public class ParamsValidatorUtils {

    /**
     * 开启hibernate validator 快速校验失败机制。
     * @author yanchen
     * @return Validator
     */
    @Bean
    public Validator EnableFastFail(){

        ValidatorFactory factory= Validation.byProvider(HibernateValidator.class).configure().addProperty("hibernate.validator.fail_fast","true").buildValidatorFactory();

        return factory.getValidator();

    }
}
