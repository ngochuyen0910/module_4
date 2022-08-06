package com.demo2.repository;

import com.demo2.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IQuestionRepository extends JpaRepository<Question,Integer> {
    @Query(value = "select question.* from question left join question_type on question.question_type_id = question_type.question_type_id where question_type.name like :search and title like :searchss",
            nativeQuery = true)
    List<Question> findByNameContaining(@Param("search") String name, @Param("searchss") String title);
}
