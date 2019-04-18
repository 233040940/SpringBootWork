package com.example.springboot.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description pagehelper插件配置
 * @date 2019-04-16 19:04
 */
@Configuration
public class PageHelperConfig {


    @Bean
    public PageHelper pageHelper() {

        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect", "mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);

        return pageHelper;
    }
}
