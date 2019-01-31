package com.springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/redis")
public class RedisControlller {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Autowired
    private StringRedisTemplate stringRedisTemplate = null;

    @RequestMapping("/stringAndHash")
    @ResponseBody
    public Map<String, Object> testStringAndHash(){
        //默认使用的是jdk序列号器
        redisTemplate.opsForValue().set("key1", "value1");
        redisTemplate.opsForValue().set("int_key", "1");

        //使用运算
        stringRedisTemplate.opsForValue().set("int", "1");
        stringRedisTemplate.opsForValue().increment("int");

        //存入hash数据
        Map<String, String> hash = new HashMap<>();
        hash.put("field1", "value1");
        hash.put("filed2", "value2");
        stringRedisTemplate.opsForHash().putAll("hash", hash);
        //增加一个字段
        stringRedisTemplate.opsForHash().put("hash", "field3", "value3");

        //绑定散列操作的key，这样可以连续对同一个散列数据类型进行操作
        BoundHashOperations hashOperations = stringRedisTemplate.boundHashOps("hash");
        hashOperations.delete("field1");
        hashOperations.put("filed4", "value4");


        Map<String, Object> map = new HashMap<>();
        map.put("success", true);
        return map;
    }
}
