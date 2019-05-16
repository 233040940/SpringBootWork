package com.example.springboot.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@ApiModel
@Builder
public class UserDTO {

    private Integer id;
    @NotBlank
    @Length(min =2,max = 20,message = "用户名不能为空，且长度在2-20个字符之间")
    @ApiModelProperty(name = "userName",value = "用户名",notes = "用户名不能为空，且长度在2-20个字符之间",dataType = "字符串")
    private String userName ;
    @NotBlank
    @Length(min=6,max =16,message = "密码不能为空，且长度在6-16个字符之间")
    @ApiModelProperty(name="passWord",value = "用户密码",notes ="密码不能为空，且长度在6-16个字符之间",dataType = "字符串")
    private String passWord;
    @NotNull
    @Pattern(regexp = "^1[3,4,5,6,7,8,9][0-9]{9}$",message = "无效的手机号")
    @ApiModelProperty(name = "mobile",value = "手机号码",notes = "11位有效的手机号",dataType = "字符串")
    private String mobile;
    @NotNull
    @Range(min = 0,max = 1,message = "性别只能为[0,1],0表示女，1表示男")
    @ApiModelProperty(name="gender",value = "性别",notes = "【0，1】0表示女,1表示男",dataType = "整数")
    private Integer gender;


}
