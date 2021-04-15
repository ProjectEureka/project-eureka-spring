package com.ProjectEureka.backend.controllers;

import com.ProjectEureka.backend.models.Answer;
import com.ProjectEureka.backend.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping("/answers")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        return new ResponseEntity<List<Answer>>(answerService.getAllAnswers(), HttpStatus.OK);
    }

    @GetMapping("/answers/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable("id") String id) throws Exception {
        return new ResponseEntity<Answer>(answerService.getAnswerById(id), HttpStatus.OK);
    }

    @PostMapping("/answers")
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer) {
        return new ResponseEntity<Answer>(answerService.createAnswer(answer), HttpStatus.CREATED);

    }

    @PutMapping("/answers/{id}")
    public ResponseEntity<Answer> updateAnswers(@PathVariable("id") String id, @RequestBody Answer answer) {
        answer.setId(id);
        return new ResponseEntity<Answer>(this.answerService.updateAnswer(id, answer), HttpStatus.CREATED);
    }

    @DeleteMapping("/answers/{id}")
    public ResponseEntity<Answer> deleteAnswer(@PathVariable("id") String id) {
        return new ResponseEntity<Answer>(answerService.deleteAnswer(id), HttpStatus.OK);
    }

}
