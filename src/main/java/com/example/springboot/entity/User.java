package com.example.springboot.entity;

import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;
import java.util.Set;

@Data
@Builder
@Alias("user")
public class User  {

    private  int id;
    private  String userName;


}
