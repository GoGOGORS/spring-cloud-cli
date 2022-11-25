package com.rx.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;

/**
 * {@code @author: jsf}
 * {{@code @Date} @date: 2022-10-15 14:56}
 * {{@code @Description} @Description: }
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry filterChain(HttpSecurity http) throws Exception {
        return http.httpBasic().and().authorizeHttpRequests()
                .anyRequest().authenticated();
    }



}
