package com.ProjectEureka.backend.impls;

import java.util.List;
import java.util.Optional;

import com.ProjectEureka.backend.models.User;
import com.ProjectEureka.backend.repositories.UserRepository;
import com.ProjectEureka.backend.services.UserService;
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
        Optional<User> userDb = this.userRepository.findById(id);

        if (userDb.isPresent()) {
            return userDb.get();
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

    @Override
    public void deleteById(String id) {
        Optional<User> deletedUser = this.userRepository.findById(id);

        if (deletedUser.isPresent()) {
            this.userRepository.delete(deletedUser.get());
        } else {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
    }

    @Override
    public User updateUser(String id, User user) {
        Optional<User> userDb = this.userRepository.findById(id);

        if (userDb.isPresent()) {
            User userUpdate = userDb.get();
            userUpdate.setFirstName(user.getFirstName());
            userUpdate.setLastName(user.getLastName());
            userUpdate.setFirebaseUuid(user.getFirebaseUuid());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setCity(user.getCity());
            userUpdate.setCategory(user.getCategory());
            userUpdate.setPictureUrl(user.getPictureUrl());
            userUpdate.setRole(user.isRole());
            userUpdate.setRating(user.getRating());

            return this.userRepository.save(userUpdate);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }

    }
}
