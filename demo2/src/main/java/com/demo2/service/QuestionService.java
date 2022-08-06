package com.demo2.service;

import com.demo2.model.Question;
import com.demo2.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private IQuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public void save(Question question) {
        question.setDateCreate(LocalDate.now());
        questionRepository.save(question);
    }

    @Override
    public Optional<Question> findById(int questionId) {
        return questionRepository.findById(questionId);
    }

    @Override
    public void update(int questionId, Question question) {
        questionRepository.save(question);
    }

    @Override
    public void remove(int questionId) {
        questionRepository.deleteById(questionId);
    }

    @Override
    public List<Question> findByNameContaining(String name, String title) {
        if (name != "") {
            return questionRepository.findByNameContaining(name, "%" + title + "%");
        }
        return questionRepository.findByNameContaining("%" + name + "%", "%" + title + "%");
    }
}
