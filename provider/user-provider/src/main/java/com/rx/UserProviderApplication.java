package com.rx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author：Ruixiang
 * Date：2022:03:21 03:21
 * ProjectName：spring-cloud-cli
 * Description:
 */

@EnableDiscoveryClient
@SpringBootApplication
public class UserProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(UserProviderApplication.class, args);
    }





}
