package com.studia.backend.controller;

import com.studia.backend.controller.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        String username = (String) token.getPrincipal().getAttributes().get("cognito:username");
        return new User(username, "USER");
    }

}

