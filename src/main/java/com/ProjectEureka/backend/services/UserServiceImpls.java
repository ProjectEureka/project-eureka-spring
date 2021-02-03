package com.ProjectEureka.backend.services;

import java.util.List;
import java.util.Optional;

import com.ProjectEureka.backend.models.User;
import com.ProjectEureka.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

@Service
public class UserServiceImpls implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        Optional<User> user = this.userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

    @Override
    public User deleteUser(String id) {
        Optional<User> user = this.userRepository.findById(id);

        if (user.isPresent()) {
            User deletedUser = user.get();
            this.userRepository.delete(user.get());
            return deletedUser;

        } else {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
    }

    @Override
    public User updateUser(String id, User user) {
        Optional<User> users = this.userRepository.findById(id);

        if (users.isPresent()) {
            User userUpdate = users.get();
            userUpdate.setFirstName(user.getFirstName());
            userUpdate.setLastName(user.getLastName());
            userUpdate.setFirebaseUuid(user.getFirebaseUuid());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setCity(user.getCity());
            userUpdate.setCategory(user.getCategory());
            userUpdate.setPictureUrl(user.getPictureUrl());
            userUpdate.setRole(user.getRole());
            userUpdate.setRating(user.getRating());

            return this.userRepository.save(userUpdate);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }

    }
}
