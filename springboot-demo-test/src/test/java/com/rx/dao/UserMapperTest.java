package com.rx.dao;

import com.rx.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;


@SpringBootTest
public class UserMapperTest {

    @Resource
    UserMapper userMapper;

    @Test
    public void test1(){
        User jsf = new User().setName("jsf-test").setAge(18).setEmail("xxx@qq.com");
        userMapper.insert(jsf);
        System.out.println(jsf.getUId());
    }


    @Test
    public void test2(){
        System.out.println("a" + String.format("%08d", 1));

    }


    @Test
    public void test3(){

        StringUtils.defaultToString("");

    }


    @Test
    public void test0(){
        float a = 1;
        float b = 0.9f;
        System.out.println(a - b);

        BigDecimal bigDecimal = BigDecimal.valueOf(1);
        BigDecimal bigDecimal1 = BigDecimal.valueOf(0.9);
    }


}