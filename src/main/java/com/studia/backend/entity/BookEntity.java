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
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private LocalDateTime releaseDate;
    private int pages;
    @CollectionTable(name = "book_categories")
    @Enumerated(value = EnumType.STRING)
    @ElementCollection(targetClass = BookCategory.class)
    private List<BookCategory> categories;

    public BookEntity(String title, String author, LocalDateTime releaseDate, int pages, List<BookCategory> categories) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.pages = pages;
        this.categories = categories;
    }
}
