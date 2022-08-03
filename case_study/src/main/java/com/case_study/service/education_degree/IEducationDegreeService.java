package com.case_study.service.education_degree;

import com.case_study.model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> findAll();

    void save(EducationDegree educationDegree);
}
