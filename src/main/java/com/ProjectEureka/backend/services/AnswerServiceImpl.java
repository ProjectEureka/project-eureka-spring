package com.ProjectEureka.backend.services;

import com.ProjectEureka.backend.repositories.AnswerRepository;
import com.ProjectEureka.backend.services.AnswerService;
import com.ProjectEureka.backend.exception.ResourceNotFoundException;
import com.ProjectEureka.backend.models.Answer;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public Answer updateAnswer(String id, Answer answer) {
        Optional<Answer> answerResult = this.answerRepository.findById(id);
        if (answerResult.isPresent()) {
            Answer answerUpdate = answerResult.get();

            answerUpdate.setMediaUrls(answer.getMediaUrls());
            answerUpdate.setAnswerDate(answer.getAnswerDate());
            answerUpdate.setDescription(answer.getDescription());
            answerUpdate.setQuestionId(answer.getQuestionId());
            answerUpdate.setUserId(answer.getUserId());

            return this.answerRepository.save(answerUpdate);
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }

    }

    @Override
    public List<Answer> getAllAnswers() {
        return this.answerRepository.findAll();
    }

    @Override
    public Answer getAnswerById(String answerId) {

        Optional<Answer> answerResult = this.answerRepository.findById(answerId);
        if (answerResult.isPresent()) {
            return answerResult.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + answerId);
        }
    }

    @Override
    public void deleteAnswer(String answerId) {
        Optional<Answer> answerResult = this.answerRepository.findById(answerId);

        if (answerResult.isPresent()) {
            this.answerRepository.delete(answerResult.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + answerId);
        }

    }

}