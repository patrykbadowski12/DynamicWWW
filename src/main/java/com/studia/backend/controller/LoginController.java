package com.studia.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

//    private final UserRepository userRepository;
//
//    @GetMapping("/user")
//    public UserDTO getUser(){
//        String username = "";
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        OAuth2AuthenticationToken token = (OAuth2AuthenticationToken) authentication;
//        username = (String) token.getPrincipal().getAttributes().get("cognito:username");
//        String email = (String) token.getPrincipal().getAttributes().get("cognito:email");
//        DAOUser user = new DAOUser(username, email, LocalDateTime.now());
//        Optional<DAOUser> dbUser = userRepository.findById(username);
//        if (!dbUser.isPresent()) {
//            userRepository.save(user);
//        }
//        return new UserDTO(username, "USER");
//    }

}

