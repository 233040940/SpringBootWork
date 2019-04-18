package com.example.springboot.mapper;

import com.example.springboot.pojo.Teacher;
import com.example.springboot.pojo.TeacherDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {

    void insert(Teacher teacher);

    TeacherDTO find(int uid);

    List<Teacher> findTeachersByUserID(int uid);
}
