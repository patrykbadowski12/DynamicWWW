package com.studia.backend.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfiguration {

    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable().csrf().disable().authorizeRequests()
                .anyRequest()
                .permitAll()
                .and()
                .oauth2Login()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("https://www.google.com/")
                .permitAll();
    }
}
