package com.example.springboot.controller;

import com.example.springboot.ResponseResult;
import com.example.springboot.pojo.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@Validated
public class FirstController  {


    @PostMapping (value = "/sayHi",produces = "application/json",consumes = "application/json")
    public  ResponseResult sayHi(@Valid @RequestBody ValidPO po){

        return new ResponseResult<ValidPO>(1,"success",po) ;
    }

     @PostMapping(consumes = "application/json")
     public String insertUser(@RequestBody @Valid ValidPO po){

        return po.toString();
     }

     @GetMapping("/{id}")
     public String getUser(@PathVariable Integer id){

        return "get user success"+id;
     }

     @DeleteMapping("/{id}")
     public String deleteUser(@PathVariable Integer id){
        return "hello"+id;
     }
     @PutMapping("/{id}")
     public String updateUser(@PathVariable Integer id, @RequestBody UserPO po){
        return "hello"+id;
     }


}
