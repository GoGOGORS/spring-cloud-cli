package com.rx;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author：Ruixiang
 * @Date：2022:03:21 06:55
 * @ProjectName：spring-cloud-cli
 * @Description:
 */

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class OrderControlApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderControlApplication.class, args);
    }

}