package com.ProjectEureka.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import com.ProjectEureka.backend.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    public Optional<User> findById(String id);
}
