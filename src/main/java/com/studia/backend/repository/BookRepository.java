package com.studia.backend.repository;

import com.studia.backend.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

    @Override
    List<BookEntity> findAll();
}
