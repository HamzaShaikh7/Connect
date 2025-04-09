package com.connect.Connect.service;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class TestRedisService {


    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    @Disabled
    public void testSendMail(){

        redisTemplate.opsForValue().set("email_add","gmail@gmail.com");
        Object o = redisTemplate.opsForValue().get("email_add");
        int a=0;
    }




}
