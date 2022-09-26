package com.rx.intercept;


import cn.hutool.core.codec.Base64;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.rx.redis.RedisConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;


@Slf4j
@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisConfig redisConfig;

    @Resource
    private RedisConnectionFactory redisConnectionFactory;

    @Test
    public void test1(){
        Properties info = redisConnectionFactory.getConnection().info();
        log.info("【Redisson 配置】：{}", info);
    }


    @Test
    public void test2(){
        String jsf = Base64.encode("jsf");
        System.out.println(jsf);
        System.out.println(Base64.decodeStr(jsf));
    }


    @Test
    public void test3(){
        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;
            {
                put("uid", Integer.parseInt("123"));
                put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
            }
        };

        System.out.println(JWTUtil.createToken(map, "1234".getBytes()));
    }


    @Test
    public void test4(){
        JWT jwt = JWTUtil.parseToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjEyMywiZXhwaXJlX3RpbWUiOjE2NjIyNzAyNzE3NTZ9.f69o6Q4qPJJk5gOcUC3q_kdG0_Om55O0aNlhi2-b-OQ");
        System.out.println(jwt.getHeader());
    }

    @Test
    public void test5(){
        JWT jwt = JWTUtil.parseToken("eyJhbGciOiJIUzI1NiIsImNhbGciOiJERUYifQ.eNpkzTsOwyAQBNC7bG1Fy4L5uEukFFZ-Z8CYIgUmMlBYUe4eKKIU1jarNyPNG1KZYADWI3EpuSAGHTxthoFJiUZp2WMHrqQcg1_HuXYFkvZiUkrPnBsiZO3TJKxRiEjw7x-di2XJu4FffrfB79dfjUgdsF6DtKXsQ8Xb4zRez1VWu8wxXPxWkRQZLUjC5wsAAP__.IhZbdKnXHGmhclRVTRuypvCrzwaVeZEdcWO5OLkbK1I");
        System.out.println(jwt.getHeader());
    }


    @Test
    public void test6(){
        System.out.println(Objects.nonNull(null));

    }


}