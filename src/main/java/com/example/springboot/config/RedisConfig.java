package com.example.springboot.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.example.springboot.utils.FastJsonRedisSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import java.time.Duration;


/**
 * redis配置文件
 */
@Configuration
@EnableCaching
@Slf4j
public class RedisConfig  extends CachingConfigurerSupport{

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private int redisPort;

    @Value("${spring.redis.password}")
    private String redisPassword;

    @Value("${spring.redis.database}")
    private int redisDatabase;


    /**
     * @return org.springframework.cache.CacheManager
     * @Description 使用redis作为Cache
     * @Param [redisConnectionFactory]
     * @Author yc
     * @Date 2019-05-13 19:34
     * @version 1.0
     */


    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {

        log.warn("--------"+redisConnectionFactory.getClass().getSimpleName());     //spring 2.X redisconnetionfactory默认采用lettuce连接工厂

        RedisCacheManager manager = new RedisCacheManager(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory), redisCacheConfiguration());
        ParserConfig.getGlobalInstance().addAccept("com.example.springboot.entity.");            //配置fastjson白名单
        // return RedisCacheManager.builder(RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory)).cacheDefaults(redisCacheConfiguration()).build();
        return manager;
    }

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {

        return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(1L))   //设置缓存过期时间
                .disableCachingNullValues()   //如果是null则不缓存
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new FastJsonRedisSerializer<>(Object.class)));    //设置value的序列化器，key为默认的StringSerializer

    }

    /**
      * @Description   cacheKey的生成策略:以cacheName+类全限定名+方法名+所有参数构成
      * @Param []
      * @return org.springframework.cache.interceptor.KeyGenerator
      * @Author yc
      * @Date 2019-05-16 02:29
      * @version 1.0
      */

    @Bean
    public KeyGenerator keyGenerator() {

        return (o, m, p) -> {

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(o.getClass().getTypeName());
            stringBuilder.append("::");
            stringBuilder.append(m.getName());
            stringBuilder.append("::");
            for (int i = 0; i < p.length; i++) {
                stringBuilder.append(p[i]);
                if (i != p.length - 1) {
                    stringBuilder.append("::");
                }
            }

            return stringBuilder.toString();

        };
    }
    @Bean
    public CacheErrorHandler errorHandler(){

       return  new RedisCacheErrorHandler();

    }

    /**
     * 配置redisTemplate 不采用默认的序列化机制
     *
     * @param redisConnectionFactory
     * @return redisTemplate
     */
    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        setSerializer(redisTemplate);
        return redisTemplate;
    }

    /**
     * 配置stringRedisTemplate 不采用默认的序列化方式
     *
     * @param redisConnectionFactory redis工厂bean
     * @return stringRedisTemplate
     */
    @Bean(name = "stringRedisTemplate")
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        setStringSerializer(stringRedisTemplate);
        return stringRedisTemplate;
    }


    //配置序列化器
    private void setSerializer(RedisTemplate template) {
        // 使用Jackson2JsonRedisSerialize 替换默认序列化
        //Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        //ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        //objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        //jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        //使用fastjson序列化
        FastJsonRedisSerializer fastJsonRedisSerializer = new FastJsonRedisSerializer(Object.class);

        // 设置value的序列化规则和 key的序列化规则
        template.setValueSerializer(fastJsonRedisSerializer);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(fastJsonRedisSerializer);
        template.setDefaultSerializer(fastJsonRedisSerializer);
        template.setEnableDefaultSerializer(true);
        template.afterPropertiesSet();


    }

    private void setStringSerializer(RedisTemplate<String, String> template) {
        RedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setDefaultSerializer(stringRedisSerializer);
        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);
        template.setHashValueSerializer(stringRedisSerializer);
    }


}
