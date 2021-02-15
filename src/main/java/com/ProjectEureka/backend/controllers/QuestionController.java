package com.ProjectEureka.backend.controllers;

import java.util.List;

import com.ProjectEureka.backend.services.QuestionService;
import com.ProjectEureka.backend.models.Question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @DeleteMapping("/questions/{id}")
    public ResponseEntity<Question> deleteQuestion(@PathVariable("id") String id) throws Exception {
        return new ResponseEntity<Question>(questionService.deleteQuestion(id), HttpStatus.OK);
    }
}