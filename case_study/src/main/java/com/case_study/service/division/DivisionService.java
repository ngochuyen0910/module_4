package com.case_study.service.division;

import com.case_study.model.employee.Divisions;
import com.case_study.repository.employee.IDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {
    @Autowired
    private IDivisionRepository divisionRepository;

    @Override
    public List<Divisions> findAll() {
        List<Divisions> temp = divisionRepository.findAll();
        return divisionRepository.findAll();
    }

    @Override
    public void save(Divisions divisions) {
        Divisions temp = divisions;
        divisionRepository.save(divisions);
    }
}
