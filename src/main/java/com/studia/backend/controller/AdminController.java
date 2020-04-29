package com.studia.backend.controller;

import com.studia.backend.entity.BookEntity;
import com.studia.backend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final BookService bookService;

    @PostMapping("/book")
    public ResponseEntity createBook(@RequestBody BookEntity bookEntity){
        try {
            bookService.saveBook(bookEntity);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }
}
