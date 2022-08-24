package com.rx.base;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-08-20 11:35}
 * {{@code @Description} @Description: }
 */

@Slf4j
@Configuration
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String token = httpRequest.getHeader("token");
        if (StringUtils.hasLength(token)){
            Integer loginUserId = Integer.parseInt(token);

            HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(httpRequest) {

                @Override
                public String[] getParameterValues(String name) {
                    if ("loginUserId".equals(name)) {
                        return new String[] { loginUserId .toString() };
                    }
                    return super.getParameterValues(name);
                }

                @Override
                public Enumeration<String> getParameterNames() {
                    Set<String> paramNames = new LinkedHashSet<>();
                    paramNames.add("loginUserId");
                    Enumeration<String> names =  super.getParameterNames();
                    while(names.hasMoreElements()) {
                        paramNames.add(names.nextElement());
                    }
                    return Collections.enumeration(paramNames);
                }

                @Override
                public ServletInputStream getInputStream(){
                    byte[] requestBody;
                    try {
                        requestBody = StreamUtils.copyToByteArray(request.getInputStream());
                        Map<Object, Object> map = JSONUtil.toBean(new String(requestBody), Map.class);
                        map.put("loginUserId", loginUserId);
                        requestBody = JSONUtil.toJsonStr(map).getBytes();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    final ByteArrayInputStream bais = new ByteArrayInputStream(requestBody);
                    return new ServletInputStream() {
                        @Override
                        public int read(){
                            return bais.read();
                        }

                        @Override
                        public boolean isFinished() {
                            return false;
                        }

                        @Override
                        public boolean isReady() {
                            return true;
                        }

                        @Override
                        public void setReadListener(ReadListener listener) {

                        }
                    };
                }

            };
            chain.doFilter(requestWrapper, httpResponse);
        } else {
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
