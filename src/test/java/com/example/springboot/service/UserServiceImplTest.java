package com.example.springboot.service;

import com.example.springboot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@MapperScan(basePackageClasses = UserMapper.class)
public class UserServiceImplTest {

    @Autowired
    private UserService service;
    @Test
    public void insert() {


    }
}