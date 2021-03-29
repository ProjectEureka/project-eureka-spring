package com.ProjectEureka.backend.services;

import java.util.ArrayList;
import java.util.Optional;

import com.ProjectEureka.backend.exception.ResourceNotFoundException;
import com.ProjectEureka.backend.models.User;
import com.ProjectEureka.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserDataServiceImpls implements DeleteUserDataService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User deleteUserData(String id){

        Optional<User> user = this.userRepository.findById(id);


        if(user.isPresent()){
            User deleteUser = user.get();

            deleteUser.setFirstName("deleted");
            deleteUser.setLastName("deleted");
            deleteUser.setFirebaseUuid("deleted");
            deleteUser.setEmail("deleted");
            deleteUser.setCity("deleted");
            deleteUser.setCategory(new ArrayList<String>());
            deleteUser.setPictureUrl("deleted");
            deleteUser.setRole(-1);
            deleteUser.setRatings(new ArrayList<Integer>());
            deleteUser.setAverageRating(0.0);

            return this.userRepository.save(deleteUser);
        }
        else{
            throw new ResourceNotFoundException("User not found with id : " + id);
        }

    }   
}