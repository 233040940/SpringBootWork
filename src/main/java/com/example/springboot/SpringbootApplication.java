package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
//@EnableScheduling
//@Async
@EnableSwagger2
public class SpringbootApplication  {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);

    }

}
