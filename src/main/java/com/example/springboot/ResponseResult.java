package com.example.springboot;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ApiModel(value = "返回类型")
@Builder
public class ResponseResult<T> implements Serializable {

    @ApiModelProperty(value = "响应代码（200表示成功,400表示客户端发生错误,500表示服务器出现未知错误）",dataType = "Integer")
    private Integer code;    //返回代码
    @ApiModelProperty(value = "success 表示成功，fail表示失败",dataType = "String")
    private String message;   //返回信息
    @ApiModelProperty(value = "详细数据或错误提示",dataType = "json格式字符串")
    private  T data;            //详细数据

}
