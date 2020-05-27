package com.studia.backend.repository;

import com.studia.backend.entity.EncyclopediaRegistrationEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EncyclopediaRegistrationRepository extends CrudRepository<EncyclopediaRegistrationEntity, Long> {

    List<EncyclopediaRegistrationEntity> findAllByVerificationFalse();
}
