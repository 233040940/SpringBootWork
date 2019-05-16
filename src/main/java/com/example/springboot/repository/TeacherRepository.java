package com.example.springboot.repository;

import com.example.springboot.entity.Teacher;
import com.example.springboot.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description TODO
 * @date 2019-05-16 05:56
 */

@Repository
public class TeacherRepository {

    @Resource
    private TeacherMapper teacherMapper;

    public List<Teacher> findTeachersByUserID(int uid){

        return teacherMapper.findTeachersByUserID(uid);
    }

    public int insertTeacher(Teacher teacher){

        return teacherMapper.insertTeacher(teacher);
    }
}
