package com.example.springboot.service;

import com.example.springboot.ResponseResult;
import com.example.springboot.pojo.ValidPO;
import org.springframework.stereotype.Service;

@Service
public class SendServiceImpl implements SendService {
    @Override
    public ResponseResult send(ValidPO po) {
        return new ResponseResult(2,"success",po);
    }
}
