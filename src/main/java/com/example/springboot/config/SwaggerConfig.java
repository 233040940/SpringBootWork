package com.example.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author yc
 * @description 注册swagger2
 */
@Configuration
public class SwaggerConfig  {

    @Bean
    public Docket productApi(){
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo()).
                select().
                apis(RequestHandlerSelectors.basePackage("com.example.springboot.controller")).          //指定swagger2扫描的包
                paths(PathSelectors.any()).
                build();
    }

    private ApiInfo apiInfo(){

        return new ApiInfoBuilder().
                title("swagger和springboot整合").
                description("swagger的api文档").
                version("1.0").build();
    }

}
