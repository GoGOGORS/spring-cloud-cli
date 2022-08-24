package com.rx.intercept;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-17 14:40}
 * {{@code @Description} @Description: }
 */

@Slf4j
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Resource
    private MyIntercept intercept;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        WebMvcConfigurer.super.configurePathMatch(configurer);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        WebMvcConfigurer.super.configureContentNegotiation(configurer);
    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        WebMvcConfigurer.super.configureAsyncSupport(configurer);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        WebMvcConfigurer.super.configureDefaultServletHandling(configurer);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        WebMvcConfigurer.super.addFormatters(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(intercept).addPathPatterns("/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**")
                // .allowedOrigins("*") 旧版本的跨域设置，新版本已经不再支持
                .allowedOriginPatterns("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600);

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        WebMvcConfigurer.super.addViewControllers(registry);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        WebMvcConfigurer.super.configureViewResolvers(registry);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        WebMvcConfigurer.super.addArgumentResolvers(resolvers);
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        WebMvcConfigurer.super.addReturnValueHandlers(handlers);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.configureMessageConverters(converters);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        WebMvcConfigurer.super.extendMessageConverters(converters);
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        WebMvcConfigurer.super.configureHandlerExceptionResolvers(resolvers);
    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        WebMvcConfigurer.super.extendHandlerExceptionResolvers(resolvers);
    }

    @Override
    public Validator getValidator() {
        return WebMvcConfigurer.super.getValidator();
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return WebMvcConfigurer.super.getMessageCodesResolver();
    }

}
