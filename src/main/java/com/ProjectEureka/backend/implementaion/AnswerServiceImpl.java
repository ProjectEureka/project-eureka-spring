package com.ProjectEureka.backend.implementaion;

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
        Optional<Answer> answerDb = this.answerRepository.findById(id);
        if (answerDb.isPresent()) {
            Answer answerUpdate = answerDb.get();

            answerUpdate.setMedia_urls(answer.getMedia_urls());
            answerUpdate.setAnswer_date(answer.getAnswer_date());
            answerUpdate.setDescription(answer.getDescription());
            answerUpdate.setQuestion_id(answer.getQuestion_id());
            answerUpdate.setUser_id(answer.getUser_id());

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

        Optional<Answer> answerDb = this.answerRepository.findById(answerId);
        if (answerDb.isPresent()) {
            return answerDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + answerId);
        }
    }

    @Override
    public void deleteAnswer(String answerId) {
        Optional<Answer> productDb = this.answerRepository.findById(answerId);

        if (productDb.isPresent()) {
            this.answerRepository.delete(productDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + answerId);
        }

    }

}