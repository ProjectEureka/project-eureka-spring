package com.ProjectEureka.backend.controllers;

import com.ProjectEureka.backend.models.User;
import com.ProjectEureka.backend.services.DeleteUserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class DeleteUserDataController {
    @Autowired
    DeleteUserDataService deleteService;
    
    @PutMapping("/user/delete/{id}")
    public ResponseEntity<User> deleteUserData(@PathVariable("id") String id) {

        return new ResponseEntity<User>(this.deleteService.deleteUserData(id), HttpStatus.CREATED);
    }
    
}
