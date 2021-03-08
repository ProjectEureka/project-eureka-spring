package com.ProjectEureka.backend.services;

import com.ProjectEureka.backend.models.Rating;
import com.ProjectEureka.backend.models.User;

public interface RatingService {

    User updateUserRating(String id, Rating rating);
}
