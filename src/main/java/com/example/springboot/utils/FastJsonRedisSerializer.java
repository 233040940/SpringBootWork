package com.example.springboot.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.base.Objects;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * @author yc
 * @description 重写FastJsonRedisSerializer   【因为导入阿里fastjson提供的源码包，始终都会报错，原因还未查明，可能是spring boot2.X以上的支持还不够友好，spring boot 1.x是源码包是没问题的】
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer <T>{

    private static  final Charset CHARSET=Charset.forName("UTF-8");     //设置字符编码
    private Class<T> clazz;

    public  FastJsonRedisSerializer(Class<T> clazz){
        super();
        this.clazz=clazz;
    }
    @Override
    public byte[] serialize(T o) throws SerializationException {         //序列化
        if(Objects.equal(o,null)) {
            return new byte[0];
        }
        return JSON.toJSONString(o, SerializerFeature.WriteClassName).getBytes(CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {

        if(bytes.length==0||Objects.equal(bytes,null)){             //反序列化
            return null;
        }
        return  JSON.parseObject(new String(bytes,CHARSET), clazz);
    }
}
