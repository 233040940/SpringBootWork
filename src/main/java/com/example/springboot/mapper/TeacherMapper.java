package com.example.springboot.mapper;

import com.example.springboot.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
  * @Description 采用xml方式配置mybatis，示例
  */

@Mapper
public interface TeacherMapper {

    int insertTeacher(Teacher teacher);

    List<Teacher> findTeachersByUserID(int uid);
}
