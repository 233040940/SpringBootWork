package com.example.springboot.config;

import ch.qos.logback.core.db.dialect.MySQLDialect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.SqlUtilConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description 配置mybatis pagehelper参数[也可在application.properties配置，通过@ConfigurationProperties 引入]
 * @date 2019-05-09 15:29
 */

@Configuration
public class PageHelperConfig {


    @Bean
    public PageHelper pageHelper() {

        SqlUtilConfig sqlUtilConfig=new SqlUtilConfig();
        sqlUtilConfig.setDialect("mysql");
        sqlUtilConfig.setOffsetAsPageNum(true);
        sqlUtilConfig.setReasonable(true);
        sqlUtilConfig.setRowBoundsWithCount(true);
        sqlUtilConfig.setSupportMethodsArguments(true);
        PageHelper pageHelper = new PageHelper();
        pageHelper.setSqlUtilConfig(sqlUtilConfig);
        return pageHelper;
    }

}
