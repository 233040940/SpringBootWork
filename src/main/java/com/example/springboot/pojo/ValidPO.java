package com.example.springboot.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;


public class ValidPO {

       @NotBlank
       @Size(max = 16,min = 2,message = "用户名只能在2-16个字符之间")
       private String userName;
       @NotBlank
       @Size(max = 20,min = 6,message = "密码必须在6-20个字符之间")
       private String passWord;

       @Pattern(regexp = "^1[3,4,5,7,8][0-9]{9}$",message = "无效的手机号")
       private String mobile;
       private  Integer gender;
       private  Integer level;

       public void setUserName(String userName) {
              this.userName = userName;
       }

       public void setPassWord(String passWord) {
              this.passWord = passWord;
       }

       public void setMobile(String mobile) {
              this.mobile = mobile;
       }

       public void setGender(Integer gender) {
              this.gender = gender;
       }

       public void setLevel(Integer level) {
              this.level = level;
       }

       public void setStatus(Integer status) {
              this.status = status;
       }

       public void setSuccess(Boolean success) {
              this.success = success;
       }

       public void setCreateTime(Date createTime) {
              this.createTime = createTime;
       }

       private  Integer status;
       @AssertTrue(message = "success 必须为true")
       private  Boolean success;

       @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss",timezone="GMT+8")
       private Date createTime;

       @Override
       public String toString() {
              return "ValidPO{" +
                      "userName='" + userName + '\'' +
                      ", passWord='" + passWord + '\'' +
                      ", mobile='" + mobile + '\'' +
                      ", gender=" + gender +
                      ", level=" + level +
                      ", status=" + status +
                      ", success=" + success +
                      ", createTime=" + createTime +
                      '}';
       }
}
