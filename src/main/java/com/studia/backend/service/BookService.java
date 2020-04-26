package com.studia.backend.service;

import com.studia.backend.entity.BookEntity;
import com.studia.backend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<BookEntity> getAllBooks(){
        return (List<BookEntity>) bookRepository.findAll();
    }

    public BookEntity getBook(Long id) {
        return bookRepository.findById(id).get();
    }
}
