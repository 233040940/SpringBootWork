package com.example.springboot.mapper;
import java.util.Map;
import com.example.springboot.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("select * from t_users where id=#{id}")
     User find(int id);

    @Insert("insert into t_users(username,mobile,gender,level,status) values(#{userName},#{mobile},#{gender},#{level},#{status})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn ="id")
     int insert(User user);

    @Select("select a.*,b.* from t_users a left join t_teachers b on a.id=b.user_id where a.id=#{id}")
     Map<String,Object> select( int id);


}
