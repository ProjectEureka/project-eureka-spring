package com.ProjectEureka.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(String firstName, String lastName) {
        return userRepository.save(new User(firstName, lastName));
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
}