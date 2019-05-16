package com.example.springboot.repository;

import com.example.springboot.entity.UserDTO;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.entity.UserPO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description TODO
 * @date 2019-04-25 22:23
 */
@Repository
public class UserRepository {

    @Resource
    private UserMapper userMapper;

    public UserPO find(int id) {

        return userMapper.find(id);
    }

    public void insert(UserPO user) {
        userMapper.insert(user);
    }


    public List<UserDTO> fndUsers(UserDTO dto){
        return userMapper.findUsers(dto);
    }
}
