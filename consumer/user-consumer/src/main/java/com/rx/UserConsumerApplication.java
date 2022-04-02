package com.rx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Author：Ruixiang
 * Date：2022:03:21 05:59
 * ProjectName：spring-cloud-cli
 * Description:
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class UserConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserConsumerApplication.class, args);
    }


}
