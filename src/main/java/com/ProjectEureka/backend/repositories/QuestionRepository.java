package com.ProjectEureka.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

import com.ProjectEureka.backend.models.Question;

public interface QuestionRepository extends MongoRepository<Question, String> {
    public Optional<Question> findById(String id);
}