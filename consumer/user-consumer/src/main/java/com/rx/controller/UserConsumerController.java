package com.rx.controller;

import com.rx.feign.UserFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author：Ruixiang
 * @Date：2022:03:21 06:55
 * @ProjectName：spring-cloud-cli
 * @Description:
 */

@RestController
@RequestMapping("/user")
public class UserConsumerController {

    @Resource
    UserFeignService userFeignService;

    @GetMapping("/addUser/{userName}")
    public String addUser(@PathVariable String userName){
        return userFeignService.addUser(userName);
    }
    
    
    


}



