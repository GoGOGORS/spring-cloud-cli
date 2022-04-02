package com.rx.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Author：Ruixiang
 * Date：2022:03:21 06:57
 * ProjectName：spring-cloud-cli
 * Description:
 */

@FeignClient(name = "user-provider")
public interface UserFeignService {

    @GetMapping("/userProvider/addUser/{userName}")
    String addUser(@PathVariable("userName") String userName);

}
