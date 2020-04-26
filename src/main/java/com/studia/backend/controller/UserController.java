package com.studia.backend.controller;

import com.studia.backend.entity.BookEntity;
import com.studia.backend.repository.BookRepository;
import com.studia.backend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final BookService bookService;
    private final BookRepository bookRepository;


    @GetMapping("/books")
    public List<BookEntity> getBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public BookEntity getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping("/book")
    public void createBook(@RequestBody BookEntity bookEntity){
        bookRepository.save(bookEntity);
    }
}
