package com.case_study.service.position;

import com.case_study.model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();

    void save(Position position);
}