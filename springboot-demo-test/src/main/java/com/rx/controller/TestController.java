package com.rx.controller;

import cn.hutool.core.util.IdUtil;
import com.rx.base.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-15 14:44}
 * {{@code @Description} @Description: }
 */

@RestController
public class TestController {


    @GetMapping("/test")
    public Object test(String id){
        return BaseResult.ok(id);
    }

    @GetMapping("/test2")
    public Object test2(String id){
        return id;
    }


    @PostMapping("/test3")
    public Object test2(@RequestBody User user){
        return BaseResult.ok(user);
    }


    public static void main(String[] args) {
        System.out.println(IdUtil.getSnowflakeNextId());
    }

}
