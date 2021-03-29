package com.ProjectEureka.backend.services;

import com.ProjectEureka.backend.models.Rating;
import com.ProjectEureka.backend.models.User;
import com.ProjectEureka.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RatingServiceImpls implements RatingService {
    @Autowired
    UserRepository userRepository;


    @Override
    public User updateUserRating(String id, Rating rating) {

        Optional<User> users = this.userRepository.findById(id);

        if (users.isPresent()) {
            User userUpdate = users.get();

            // get current rating ArrayList of a user
            ArrayList<Double> userRating = userUpdate.getRatings();

            // append new rating to current ArrayList
            userRating.add(rating.getRating());

            // get average of a rating ArrayList
            Double averageRating = userRating.stream()
                    .mapToDouble(number -> number)
                    .average().getAsDouble();

            // round to 1 decimal place
            double scale = Math.pow(10, 1);

            // save changes to user's table
            userUpdate.setRatings(userRating);
            userUpdate.setAverageRating(Math.round(averageRating * scale) / scale);

            return this.userRepository.save(userUpdate);
        } else {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }

    }
}
