package com.studia.backend.controller;

import com.studia.backend.entity.BookEntity;
import com.studia.backend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final BookRepository bookRepository;

    @PostMapping("/book")
    public void createBook(@RequestBody BookEntity bookEntity){
        bookRepository.save(bookEntity);
    }
}
