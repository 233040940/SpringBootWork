package com.example.springboot.controller;

import com.example.springboot.ResponseResult;
import com.example.springboot.annotation.RepeatSubmitValidate;
import com.example.springboot.entity.UserDTO;
import com.example.springboot.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.util.List;


/**
 * @author yc
 * @version 1.0
 * @project springboot
 * @description TODO
 * @date 2019-04-20 01:30
 */
@Api(value = "api-users", description = "用户操作api")
@Controller
@Slf4j
@RequestMapping(value = "/api-users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(produces = "application/json", consumes = "application/json")
    @ResponseBody
    @RepeatSubmitValidate
    @ApiOperation(value = "添加用户详细信息", produces = "application/json", httpMethod = "POST", response = ResponseResult.class)
    public ResponseResult<UserDTO> insertUser(@Validated @RequestBody UserDTO dto) {
        return userService.insert(dto);
    }


    @ApiOperation(value = "通过id获取用户详细信息", produces = "application/json", httpMethod = "GET", response = ResponseResult.class)
    @GetMapping(value = "/{id}", produces = "application/json")
    @ResponseBody
    @ApiParam(name = "id", value = "用户id", type = "path")
    public ResponseResult getUser(@PathVariable Integer id) {


        return userService.get(id);
    }

    /**
      * @Description  简单测试pagehelper
      * @Param [offset, limit]
      * @return com.example.springboot.ResponseResult
      * @Author yc
      * @Date 2019-05-16 01:55
      * @version 1.0
      */

    @GetMapping(value = "", produces = "application/json")
    @ResponseBody
    public ResponseResult getUsers(@RequestParam(name = "offset", defaultValue = "1", required = false) Integer offset,
                                   @RequestParam(name = "limit", defaultValue = "10", required = false) Integer limit) {


        UserDTO dto=UserDTO.builder().userName("yc").build();

        PageHelper.offsetPage(offset, limit,"id desc,gender asc");

        List<UserDTO> list=userService.findUsers(dto);

      return   ResponseResult.builder().code(200).message("success").data(new PageInfo<>(list)).build();

    }

}
