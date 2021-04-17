package com.ProjectEureka.backend.repositories;

import com.ProjectEureka.backend.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public Optional<User> findById(String id);
}
