package com.studia.backend.repository;

import com.studia.backend.entity.EncyclopediaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncyclopediaRepository extends CrudRepository<EncyclopediaEntity, Long> {
    @Override
    List<EncyclopediaEntity> findAll();

}
