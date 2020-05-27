package com.studia.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name = "encyclopedia_registration")
public class EncyclopediaRegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private String author;
    private Date date;
    private boolean verification;
    private Long encyclopediaId;

}
