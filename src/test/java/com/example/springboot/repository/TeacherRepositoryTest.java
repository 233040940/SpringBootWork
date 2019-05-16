package com.example.springboot.repository;


import com.example.springboot.entity.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class TeacherRepositoryTest {
    
    /**
      * @Description 
      * @Param  采用xml方式配置mybatis
      * @return
      * @Author yc
      * @Date 2019-05-16 06:31
      * @version 1.0
      */
    

    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public  void main(){

    //    int rows=teacherRepository.insertTeacher(Teacher.builder().id(20).name("赵四").userId(3).build());
    //    log.info("---insert rows--"+rows);
          List<Teacher> teachers=teacherRepository.findTeachersByUserID(3);
          log.info("----teachers---"+teachers.toString());

    }

}