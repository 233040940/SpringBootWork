package com.example.springboot.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 使用fastjson序列化和反序列化
 */
public class JsonUtils {

    //json字符串-简单对象型
    private static final String  JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";

    //json字符串-数组类型
    private static final String  JSON_ARRAY_STR = "{\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

    //复杂格式json字符串
    private static final String  COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270}," +
            "\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";
/*
    private static void parseStringToJson(){

       JSONObject object=JSONObject.parseObject(JSON_OBJ_STR);

        parseJsonToJavaObject(object);
    }*/

    private static void parseStringArraysToJson(){

      //  JSONArray array=JSONArray.parseArray(JSON_ARRAY_STR);

       // List<Student> students= JSONArray.parseObject(JSON_ARRAY_STR,new TypeReference<ArrayList<Student>>(){});

        Teacher t=JSONObject.parseObject(JSON_ARRAY_STR,Teacher.class);



        System.out.println(t.getStudents().toString());

    }
    public   static Object parseJsonToJavaObject(JSONObject object,Class clazz){
     return object.toJavaObject(clazz);
    }

   /* private  static  void parseJavaObjectToJson(){
        Student student=new Student("yanchen",24);
       JSONObject o=(JSONObject) JSONObject.toJSON(student);
       String str= JSONObject.toJSONString(student);

        System.out.println(str);
    }*/

   /* public static void main(String[] args) {
        parseStringArraysToJson();
        parseJavaObjectToJson();
        parseStringToJson();
   }
   */
}
