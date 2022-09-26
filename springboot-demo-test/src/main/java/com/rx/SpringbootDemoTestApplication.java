package com.rx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-08 09:57}
 * {{@code @Description} @Description: }
 */

@MapperScan("com.rx.dao")
@SpringBootApplication
public class SpringbootDemoTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoTestApplication.class, args);

    }

}
