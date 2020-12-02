package com.ProjectEureka.backend;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public User findByFirstName(String firstName);

    public User findByLastName(String lastName);
}
