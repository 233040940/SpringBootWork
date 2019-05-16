package com.example.springboot.entity;

import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("teacher")
@Builder
public class Teacher {

    private  int  id;
    private String name;
    private  int userId;
    private  User user;

}
