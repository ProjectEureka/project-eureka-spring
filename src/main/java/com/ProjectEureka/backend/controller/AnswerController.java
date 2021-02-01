package com.ProjectEureka.backend.controller;

import java.util.List;

import com.ProjectEureka.backend.services.AnswerService;
import com.ProjectEureka.backend.models.Answer;

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
@RequestMapping("/api/v1")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @GetMapping("/answers")
    public ResponseEntity<List<Answer>> getallAnswers() {
        return ResponseEntity.ok().body(answerService.getAllAnswers());
    }

    @GetMapping("/answers/{id}")
    public ResponseEntity<Answer> getAnswerById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body(answerService.getAnswerById(id));
    }

    @PostMapping("/answers")
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer) {
        return ResponseEntity.ok().body(this.answerService.createAnswer(answer));
    }

    @PutMapping("/answers/{id}")
    public ResponseEntity<Answer> updateAnswers(@PathVariable("id") String id, @RequestBody Answer answer) {
        answer.setId(id);
        return ResponseEntity.ok().body(this.answerService.updateAnswer(id, answer));
    }

    @DeleteMapping("/answers/{id}")
    public HttpStatus deleteAnswer(@PathVariable("id") String id) {
        this.answerService.deleteAnswer(id);
        return HttpStatus.OK;
    }

}

