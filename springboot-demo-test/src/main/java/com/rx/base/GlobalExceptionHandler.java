package com.rx.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-23 17:46}
 * {{@code @Description} @Description: }
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public BaseResult<Object> runtimeExceptionHandler(HttpServletRequest req, RuntimeException e)  {
        log.error("URL: {}, HTTP_METHOD：{}, 程序运行期异常：{}", req.getRequestURL(), req.getMethod(), e.getMessage());
        return BaseResult.error(e.getMessage());
    }


    @ResponseBody
    @ExceptionHandler(value = ClassNotFoundException.class)
    public BaseResult<Object> classNotFountExceptionHandler(HttpServletRequest req, ClassNotFoundException e)  {
        log.error("URL: {}, HTTP_METHOD：{}, 找不到加载类异常：{}", req.getRequestURL(), req.getMethod(), e.getMessage());
        return BaseResult.error(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = IOException.class)
    public BaseResult<Object> ioExceptionHandler(HttpServletRequest req, IOException e)  {
        log.error("URL: {}, HTTP_METHOD：{}, 文件IO异常：{}", req.getRequestURL(), req.getMethod(), e.getMessage());
        return BaseResult.error(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public BaseResult<Object> nullExceptionHandler(HttpServletRequest req, NullPointerException e)  {
        log.error("URL: {}, HTTP_METHOD：{}, 空指针异常：{}", req.getRequestURL(), req.getMethod(), e.getMessage());
        return BaseResult.error(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = SQLException.class)
    public BaseResult<Object> sqlExceptionHandler(HttpServletRequest req, SQLException e)  {
        log.error("URL: {}, HTTP_METHOD：{}, SQL异常：{}", req.getRequestURL(), req.getMethod(), e.getMessage());
        return BaseResult.error(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = IllegalStateException.class)
    public BaseResult<Object> illegalStateExceptionHandler(HttpServletRequest req, IllegalStateException e)  {
        log.error("URL: {}, HTTP_METHOD：{}, 无效状态异常：{}", req.getRequestURL(), req.getMethod(), e.getMessage());
        return BaseResult.error(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public BaseResult<Object> noHandlerFoundExceptionHandler(HttpServletRequest req, NoHandlerFoundException e)  {
        log.error("URL: {}, HTTP_METHOD：{}, 请求路径异常：{}", req.getRequestURL(), req.getMethod(), e.getMessage());
        return BaseResult.error(404, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public BaseResult<Object> exceptionHandler(HttpServletRequest req, Exception e){
        log.error("URL: {}, HTTP_METHOD：{}, 全局异常：{}", req.getRequestURL(), req.getMethod(), e.getMessage());
        return BaseResult.error(e.getMessage());
    }


}
