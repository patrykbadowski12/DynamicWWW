package com.studia.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @UniqueElements
    private String username;
    @Column
    @JsonIgnore
    private String password;
    private String role;
    @CollectionTable(name = "borrow_books")
    @ElementCollection(targetClass = BookEntity.class)
    private List<BookEntity> borrowBooks;




}