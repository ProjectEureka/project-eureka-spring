package com.ProjectEureka.backend.controllers;

import com.ProjectEureka.backend.models.Rating;
import com.ProjectEureka.backend.models.User;
import com.ProjectEureka.backend.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PutMapping("/users/{id}/rating")
    public ResponseEntity<User> updateUserRating(@PathVariable("id") String id, @RequestBody Rating rating) {
        return ResponseEntity.ok().body(this.ratingService.updateUserRating(id, rating));
    }
}
