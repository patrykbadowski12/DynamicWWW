package com.studia.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.studia.backend.util.BookCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class DAOUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;
    private String role;
    @CollectionTable(name = "borrow_books")
    @ElementCollection(targetClass = BookEntity.class)
    private List<BookEntity> borrowBooks;




}