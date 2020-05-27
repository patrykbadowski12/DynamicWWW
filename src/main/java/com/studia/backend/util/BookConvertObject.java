package com.studia.backend.util;

import com.studia.backend.entity.BookEntity;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
public class BookConvertObject {

    private Long id;
    private String key;
    private String title;
    private String author;
    private LocalDateTime releaseDate;
    private int pages;
    private List<BookCategory> categories;

    public BookConvertObject(BookEntity bookEntity) {
        this.id = bookEntity.getId();
        this.title = bookEntity.getTitle();
        this.author = bookEntity.getAuthor();
        this.releaseDate = bookEntity.getReleaseDate();
        this.pages = bookEntity.getPages();
        this.categories = bookEntity.getCategories();
        this.key = createKey(bookEntity.getReleaseDate());
    }

    private String createKey(LocalDateTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        return time.format(formatter);
    }
}
