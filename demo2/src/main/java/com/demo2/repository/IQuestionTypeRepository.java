package com.demo2.repository;

import com.demo2.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IQuestionTypeRepository extends JpaRepository<QuestionType, Integer> {
}
