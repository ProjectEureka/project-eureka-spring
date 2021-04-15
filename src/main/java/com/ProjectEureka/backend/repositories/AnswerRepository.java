package com.ProjectEureka.backend.repositories;

import com.ProjectEureka.backend.models.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends MongoRepository<Answer, String> {
    public Optional<Answer> findById(String id);

    @Query(value = "{ 'user_id' : ?0 }")
    public List<Answer> findByUserId(String id);

    @Query(value = "{ 'question_id' : ?0 }")
    public List<Answer> findByQuestionId(String questionId);
}