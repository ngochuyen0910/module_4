package com.case_study.service.division;

import com.case_study.model.employee.Divisions;

import java.util.List;

public interface IDivisionService {
    List<Divisions> findAll();

    void save(Divisions divisions);
}
