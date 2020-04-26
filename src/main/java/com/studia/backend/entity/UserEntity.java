package com.studia.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data // robi getery + setery
@Entity //adnotacja
@Table
public class UserEntity {

    @Id
    private String username;
    private String email;
    private LocalDateTime registrationDate;

}
