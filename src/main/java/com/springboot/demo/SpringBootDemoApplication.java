package com.springboot.demo;

import com.springboot.demo.aspect.MyAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

//Spring Boot入门文件
@SpringBootApplication
@EntityScan(basePackages = "com.springboot.demo.pojo")
@MapperScan(basePackages = "com.springboot.demo.*", annotationClass = Repository.class)
//使用注解驱动缓存机制
@EnableCaching
public class SpringBootDemoApplication {


    @Bean(name = "myAspect")
    public MyAspect initMyAspect() {
        return new MyAspect();
    }

    @Autowired
    private RedisTemplate redisTemplate = null;

    @PostConstruct
    public void init() {
        initRedisTemplate();
    }

    private void initRedisTemplate() {
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }

}

