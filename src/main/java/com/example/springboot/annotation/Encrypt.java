package com.example.springboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Encrypt
 * @version 1.0
 * @project springboot
 * @description 自定义注解加密，解密
 * @date 2019-05-16 06:59
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Encrypt {

    boolean value() default false;
}
