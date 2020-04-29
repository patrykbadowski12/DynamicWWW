package com.studia.backend.repository;

import com.studia.backend.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
        UserEntity findByUsername(String username);
}
