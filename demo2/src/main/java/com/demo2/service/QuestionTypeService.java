package com.demo2.service;

import com.demo2.model.QuestionType;
import com.demo2.repository.IQuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTypeService implements IQuestionTypeService {
    @Autowired
    private IQuestionTypeRepository questionTypeRepository;

    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public void save(QuestionType questionType) {
        questionTypeRepository.save(questionType);
    }
}
