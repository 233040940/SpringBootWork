package com.example.springboot.service;

import com.example.springboot.ResponseResult;
import com.example.springboot.entity.UserDTO;

import java.util.List;

/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description TODO
 * @date 2019-04-19 21:08
 */
public interface UserService {

    ResponseResult insert(UserDTO dto);

    ResponseResult get(int id);

    List<UserDTO> findUsers(UserDTO dto);
}
