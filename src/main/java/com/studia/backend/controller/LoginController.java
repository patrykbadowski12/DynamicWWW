package com.studia.backend.controller;

import com.studia.backend.controller.entity.User;
import com.studia.backend.entity.UserEntity;
import com.studia.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserRepository userRepository;

    @GetMapping("/user")
    public User getUser(){
        String username = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
        username = (String) token.getPrincipal().getAttributes().get("cognito:username");
        String email = (String) token.getPrincipal().getAttributes().get("cognito:email");
        UserEntity user = new UserEntity(username, email, LocalDateTime.now());
        Optional<UserEntity> dbUser = userRepository.findById(username);
        if (!dbUser.isPresent()) {
            userRepository.save(user);
        }
        return new User(username, "USER");
    }

}

