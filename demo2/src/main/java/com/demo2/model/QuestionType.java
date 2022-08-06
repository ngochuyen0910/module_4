package com.demo2.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuestionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionTypeId;
    private String name;

    @OneToMany(mappedBy = "questionType")
    private Set<Question> question;

    public QuestionType() {
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Question> getQuestion() {
        return question;
    }

    public void setQuestion(Set<Question> question) {
        this.question = question;
    }
}
