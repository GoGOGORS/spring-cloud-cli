package com.rx.log;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.rx.base.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-15 14:27}
 * {{@code @Description} @Description: }
 */

@Slf4j
@Aspect
@Configuration
public class LoggerAspect {


    @Pointcut("execution(* com.rx.controller.*..*(..))")
    public void executeService(){

    }

    @Around("executeService()")
    public Object doAround(ProceedingJoinPoint pjp){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        assert servletRequestAttributes != null;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        Object result;

        try {
            String url = request.getRequestURL().toString();
            String method = request.getMethod();
            String uri = request.getRequestURI();
            String queryString = request.getQueryString();
            List<Object> postReqParam = Arrays.asList(pjp.getArgs());

            String params = "";
            if ("POST".equals(method) && !CollectionUtils.isEmpty(postReqParam)) {
                params = JSONUtil.toJsonStr(postReqParam);
            } else if ("GET".equals(method) && StringUtils.hasLength(queryString)) {
                params = URLDecoder.decode(queryString, "UTF-8");
            }

            log.info("request url: {}, request type: {}, request token: {}, request params: {}",
                    url, method, request.getHeader("Authorization"), params);
            result = pjp.proceed(pjp.getArgs());
            if (!ObjectUtil.isEmpty(result)){
                JSONConfig jsonConfig = new JSONConfig();
                jsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
                log.info("response result: {}", JSONUtil.toJsonStr(result, jsonConfig));
            }
            return result;
        } catch (Throwable e){
            log.error("系统异常：", e);
            return BaseResult.error(e.getMessage());
        }

    }


}
