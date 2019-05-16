package com.example.springboot.mapper;
import java.util.List;
import java.util.Map;

import com.example.springboot.entity.UserDTO;
import com.example.springboot.entity.UserPO;
import org.apache.ibatis.annotations.*;

/**
  * @Description  以注解的方式配置mybatis mapper，示例
  * @Author yc
  * @version 1.0
  */

@Mapper
public interface UserMapper {

    @Select("select * from t_users where id=#{id} limit 1")
     UserPO find(int id);

    @Insert("insert into t_users(username,password,mobile,gender,level,status) values(#{userName},#{passWord},#{mobile},#{gender},#{level},#{status})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn ="id")
    void insert(UserPO user);

    @Select("select a.*,b.* from t_users a left join t_teachers b on a.id=b.user_id where a.id=#{id}")
     Map<String,Object> select( int id);

    @Select("select * from t_users where username=#{userName}")
    List<UserDTO> findUsers(UserDTO dto);
}
