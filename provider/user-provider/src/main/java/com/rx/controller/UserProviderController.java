package com.rx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：Ruixiang
 * @Date：2022:03:21 06:55
 * @ProjectName：spring-cloud-cli
 * @Description:
 */

@RestController
@RequestMapping("/userProvider")
public class UserProviderController {

    @GetMapping("/addUser/{userName}")
    public String addUser(@PathVariable String userName){
        return userName;
    }


}



