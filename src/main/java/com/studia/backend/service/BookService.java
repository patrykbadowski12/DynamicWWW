package com.studia.backend.service;

import com.studia.backend.entity.BookEntity;
import com.studia.backend.entity.UserEntity;
import com.studia.backend.repository.BookRepository;
import com.studia.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        return bookRepository.findById(id).orElse(null);
    }

    public void saveBook(BookEntity bookEntity) throws Exception {
        bookEntity.setReleaseDate(LocalDateTime.now());
        bookRepository.save(bookEntity);
    }

}
