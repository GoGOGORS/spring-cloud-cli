package com.rx.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-10-15 15:34}
 * {{@code @Description} @Description: }
 */

public class JwtAuthenticationLoginConfig extends AbstractAuthenticationProcessingFilter {


    protected JwtAuthenticationLoginConfig(String defaultFilterProcessesUrl) {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken authenticationRequest =
                new UsernamePasswordAuthenticationToken(userName, password);

        return getAuthenticationManager().authenticate(authenticationRequest);
    }


}
