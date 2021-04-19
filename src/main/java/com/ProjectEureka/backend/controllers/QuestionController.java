package com.ProjectEureka.backend.controllers;

import com.ProjectEureka.backend.models.Question;
import com.ProjectEureka.backend.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestions() throws Exception {
        return new ResponseEntity<List<Question>>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @PostMapping("/questions")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question) throws Exception {
        return new ResponseEntity<Question>(questionService.createQuestion(question), HttpStatus.CREATED);
    }

    @GetMapping("/questions/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") String id) throws Exception {
        return new ResponseEntity<Question>(questionService.getQuestionById(id), HttpStatus.OK);
    }

    @PutMapping("/questions/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") String id, @RequestBody Question question) {
        question.setId(id);
        return new ResponseEntity<Question>(questionService.updateQuestion(id, question), HttpStatus.CREATED);
    }

    @PutMapping("/questions/{id}/archive")
    public ResponseEntity<Question> updateQuestionVisibility(@PathVariable("id") String id) {
        return new ResponseEntity<Question>(questionService.updateQuestionVisibility(id), HttpStatus.CREATED);
    }


    @DeleteMapping("/questions/{id}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable("id") String id) throws Exception {
        return new ResponseEntity<Question>(questionService.deleteQuestion(id), HttpStatus.OK);
    }
}