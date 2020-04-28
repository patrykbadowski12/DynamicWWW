package com.studia.backend.service;

import com.studia.backend.entity.DAOUser;
import com.studia.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public DAOUser getUser(Long id){
        return userRepository.findById(id).orElse(null);
    }
}
