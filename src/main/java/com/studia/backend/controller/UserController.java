package com.studia.backend.controller;

import com.studia.backend.entity.BookEntity;
import com.studia.backend.entity.DAOUser;
import com.studia.backend.repository.BookRepository;
import com.studia.backend.service.BookService;
import com.studia.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final BookService bookService;
    private final BookRepository bookRepository;
    private final UserService userService;

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

    @PostMapping("/book/borrow")
    public void borrowBook(@RequestParam Long idBook, @RequestParam Long idUser){
        bookService.borrowBook(idBook, idUser);
    }

    @GetMapping("/{id}")
    public DAOUser getUser(@PathVariable Long id){
      return userService.getUser(id);
    }
}
