package com.rx.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-16 10:58}
 * {{@code @Description} @Description: }
 */

@Slf4j
@Aspect
@Configuration
public class UnCommitServiceImpl {


    @Pointcut("@annotation(com.rx.annotation.UnCommit)")
    public void unCommitService(){

    }


    @Around("unCommitService()")
    public Object doCheckRepeatable(ProceedingJoinPoint pjp) throws Throwable {
        log.info("测试自定义注解的使用");
        return pjp.proceed();
    }



}
