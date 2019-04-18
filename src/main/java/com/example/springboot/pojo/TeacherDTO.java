package com.example.springboot.pojo;

import java.util.Set;

public class TeacherDTO {

     private  User user;
     private Set<Teacher> teachers;

    public void setUser(User user) {
        this.user = user;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "user=" + user +
                ", teachers=" + teachers +
                '}';
    }
}
