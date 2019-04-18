package com.example.springboot.service;

import com.example.springboot.ResponseResult;
import com.example.springboot.pojo.ValidPO;

public interface SendService {

    ResponseResult send(ValidPO po);
}
