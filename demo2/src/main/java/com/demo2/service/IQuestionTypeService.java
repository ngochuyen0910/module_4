package com.demo2.service;

import com.demo2.model.QuestionType;

import java.util.List;

public interface IQuestionTypeService {
    List<QuestionType> findAll();

    void save(QuestionType questionType);
}
