package com.demo2.service;

import com.demo2.model.Question;

import java.util.List;
import java.util.Optional;

public interface IQuestionService {
    List<Question> findAll();

    void save(Question question);

    Optional<Question> findById(int questionId);

    void update(int questionId, Question question);

    void remove(int questionId);

    List<Question> findByNameContaining(String name, String title);
}