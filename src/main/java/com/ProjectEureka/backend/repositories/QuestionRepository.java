package com.ProjectEureka.backend.repositories;

import com.ProjectEureka.backend.models.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends MongoRepository<Question, String> {
    public Optional<Question> findById(String id);

    @Query(value = "{ 'user_id' : ?0 }")
    public List<Question> findByUserId(String id);
}