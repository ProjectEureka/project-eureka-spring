package com.ProjectEureka.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ProjectEureka.backend.models.Answer;

public interface AnswerRepository extends MongoRepository<Answer, String> {

}