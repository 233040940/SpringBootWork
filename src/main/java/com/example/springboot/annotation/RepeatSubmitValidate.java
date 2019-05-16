package com.example.springboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author RepeatSubmitValidate
 * @version 1.0
 * @project springboot
 * @description 重复提交验证 自定义注解
 * @date 2019-04-20 18:49
 */

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RepeatSubmitValidate {

    boolean valid() default true;
}
