package com.example.springboot.entity;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class UserPO implements Serializable {

    private int id;
    private String userName;   //用户名
    private String passWord;   //密码
    private String mobile;     //手机号
    private int gender;        //性别
    private int level;         //用户等级
    private int status;        //用户状态


}
