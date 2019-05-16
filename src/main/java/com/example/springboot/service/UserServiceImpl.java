package com.example.springboot.service;

import com.example.springboot.ResponseResult;
import com.example.springboot.entity.UserDTO;
import com.example.springboot.entity.UserPO;
import com.example.springboot.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description TODO
 * @date 2019-04-19 21:09
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<UserDTO> findUsers(UserDTO dto) {
        return repository.fndUsers(dto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public ResponseResult insert(UserDTO dto) {

        UserPO userPO=UserPO.builder().level(1).status(1).build();
        BeanUtils.copyProperties(dto, userPO);

        repository.insert(userPO);

        return ResponseResult.builder().code(200).message("success").data(userPO).build();
    }

    @Override

    public ResponseResult get(int id) {

        return ResponseResult.builder().code(200).message("success").data(repository.find(id)).build();
    }
}
