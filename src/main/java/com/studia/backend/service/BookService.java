package com.studia.backend.service;

import com.studia.backend.entity.BookEntity;
import com.studia.backend.entity.DAOUser;
import com.studia.backend.repository.BookRepository;
import com.studia.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public List<BookEntity> getAllBooks(){
        return bookRepository.findAll();
    }

    public BookEntity getBook(Long id) {
        return bookRepository.findById(id).get();
    }

    public void borrowBook(Long idBook, Long idUser){
        BookEntity borrowBook = bookRepository.findById(idBook).orElse(null);
        DAOUser user = userRepository.findById(idUser).orElse(null);
        if(borrowBook != null && user != null){
            user.getBorrowBooks().add(borrowBook);
            userRepository.save(user);
        }
    }
}
