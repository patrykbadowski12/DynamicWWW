package com.studia.backend.controller.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String username;
    private String role;
}
