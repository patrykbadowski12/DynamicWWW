package com.studia.backend.repository;

import com.studia.backend.entity.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<DAOUser, Integer> {
        DAOUser findByUsername(String username);
}
