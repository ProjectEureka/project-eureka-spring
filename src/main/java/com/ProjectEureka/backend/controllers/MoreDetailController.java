package com.ProjectEureka.backend.controllers;

import com.ProjectEureka.backend.models.MoreDetail;
import com.ProjectEureka.backend.services.MoreDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class MoreDetailController {
    @Autowired
    private MoreDetailService moreDetailService;

    @GetMapping("/questions/{id}/details")
    public ResponseEntity<MoreDetail> getQuestionById(@PathVariable("id") String id) throws Exception {
        return new ResponseEntity<MoreDetail>(moreDetailService.getQuestionById(id), HttpStatus.OK);
    }
}
