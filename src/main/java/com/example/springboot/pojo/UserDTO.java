package com.example.springboot.pojo;

import java.util.List;

public class UserDTO {


    private int id;
    private String userName;
    private String mobile;

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    private List<Teacher> teachers;


    public void setTeachers(List<Teacher> teacher) {
        this.teachers = teacher;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "uid=" + id +
                ", userName='" + userName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
