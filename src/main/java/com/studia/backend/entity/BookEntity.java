package com.studia.backend.entity;

import com.studia.backend.util.BookCategory;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private LocalDateTime releaseDate;
    private int totalPages;
    @Column
    @Enumerated
    @ElementCollection(targetClass = BookCategory.class)
    private List<BookCategory> categories;

    public BookEntity(String title, String author, LocalDateTime releaseDate, int totalPages, List<BookCategory> categories) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.totalPages = totalPages;
        this.categories = categories;
    }
}
