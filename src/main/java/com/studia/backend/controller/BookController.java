package com.studia.backend.controller;

import com.studia.backend.entity.BookEntity;
import com.studia.backend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookEntity>> getBooks() {
        List<BookEntity> books = bookService.getAllBooks();
        if (!books.isEmpty()) {
            return new ResponseEntity<>(books, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookEntity> getBook(@PathVariable Long id) {
        BookEntity book = bookService.getBook(id);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/book/borrow")
    public ResponseEntity borrowBook(@RequestParam Long idBook, @RequestParam Long idUser) {
        try {
            bookService.borrowBook(idBook, idUser);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

