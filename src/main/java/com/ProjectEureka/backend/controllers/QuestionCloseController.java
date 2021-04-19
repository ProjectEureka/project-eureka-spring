package com.ProjectEureka.backend.controllers;

import com.ProjectEureka.backend.models.Question;
import com.ProjectEureka.backend.services.QuestionCloseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class QuestionCloseController {
    @Autowired
    QuestionCloseService questionCloseService;

    @PutMapping("/question/{id}/close")
    public ResponseEntity<Question> updateQuestionClose(@PathVariable("id") String id, @RequestBody String answerId) {
        return new ResponseEntity<Question>(questionCloseService.updateQuestionClose(id, answerId), HttpStatus.CREATED);
    }

}
