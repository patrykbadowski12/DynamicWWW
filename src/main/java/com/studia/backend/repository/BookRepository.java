package com.studia.backend.repository;

import com.studia.backend.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Long> {

    @Override
    List<BookEntity> findAll();
    List<BookEntity> findAllByReleaseDateBetween(LocalDateTime startDate, LocalDateTime endDate);

}
