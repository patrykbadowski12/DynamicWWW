package com.studia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data // robi getery + setery
@Entity //adnotacja
@Table
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)  //ctrl + spacja = podpowiada
    private long id;
    private String email;

}
