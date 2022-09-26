package com.rx.controller;

import com.rx.base.BaseResult;
import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-15 14:44}
 * {{@code @Description} @Description: }
 */

@RestController
public class TestController {


    @Resource
    RedissonClient redissonClient;

    @Resource
    Redisson redisson;


    @GetMapping("/test")
    public BaseResult<Object> test(Integer loginUserId, String name, String id){
        return BaseResult.ok(loginUserId + ", " + name + ", " + id);
    }

    @GetMapping("/test2")
    public Object test2(String id){
        return id;
    }


    @PostMapping("/test3")
    public BaseResult<Object> test3(@RequestBody User user){
        return BaseResult.ok(user);
    }


    @GetMapping("/test4")
    public BaseResult<Object> test4(){
        return BaseResult.ok();
    }


    @GetMapping("/test5")
    public BaseResult<Object> test5(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = LocalDate.now().format(dateTimeFormatter);
        RAtomicLong atomicLong = redisson.getAtomicLong(now);
        atomicLong.expire(Duration.ofDays(1));
        return BaseResult.ok(now + "" + String.format("%08d", atomicLong.incrementAndGet()));
    }






}
