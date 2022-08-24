package com.rx.redis;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-18 16:24}
 * {{@code @Description} @Description: }
 */

@Component
public class RedisLock {


    public boolean setLock(String key, Integer timeOut, TimeUnit timeUnit){


        return true;
    }


}
