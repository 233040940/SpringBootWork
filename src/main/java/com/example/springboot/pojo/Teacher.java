package com.example.springboot.pojo;

import lombok.Data;

@Data
public class Teacher {

    private  int  id;
    private String name;
    private  int userId;
    private User user;

}
