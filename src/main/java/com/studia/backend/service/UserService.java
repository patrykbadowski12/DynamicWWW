package com.studia.backend.service;

import com.studia.backend.entity.UserEntity;
import com.studia.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity getUser(String username){
        return userRepository.findByUsername(username);
    }
}
