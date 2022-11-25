package com.rx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-10-27 11:57}
 * {{@code @Description} @Description: }
 */

@RestController
public class TestController {


    @GetMapping("/hello")
    public String request() {
        return "hello";
    }



}
