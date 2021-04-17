package com.ProjectEureka.backend.controllers;

import com.ProjectEureka.backend.models.Profile;
import com.ProjectEureka.backend.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class UserProfileController {
    @Autowired
    private ProfileService profileService;

    @GetMapping("profile/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable("id") String id) throws Exception {
        return new ResponseEntity<Profile>(profileService.getProfile(id), HttpStatus.OK);
    }
}
