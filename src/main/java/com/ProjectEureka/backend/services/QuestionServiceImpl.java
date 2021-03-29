package com.ProjectEureka.backend.services;

import com.ProjectEureka.backend.repositories.QuestionRepository;
import com.ProjectEureka.backend.exception.ResourceNotFoundException;
import com.ProjectEureka.backend.models.Question;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(String id, Question question) {
        Optional<Question> questionResult = this.questionRepository.findById(id);
        if (questionResult.isPresent()) {
            Question questionUpdate = questionResult.get();

            questionUpdate.setTitle(question.getTitle());
            questionUpdate.setQuestionDate(question.getQuestionDate());
            questionUpdate.setDescription(question.getDescription());
            questionUpdate.setCategory(question.getCategory());
            questionUpdate.setMediaUrls(question.getMediaUrls());

            return this.questionRepository.save(questionUpdate);
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public List<Question> getAllQuestions() {
        return this.questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(String id) {

        Optional<Question> questionResult = this.questionRepository.findById(id);
        if (questionResult.isPresent()) {
            return questionResult.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }

    @Override
    public Question deleteQuestion(String id) {
        Optional<Question> questionResult = this.questionRepository.findById(id);

        if (questionResult.isPresent()) {
            Question deletedQuestion = questionResult.get();
            this.questionRepository.delete(deletedQuestion);
            return deletedQuestion;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }
}