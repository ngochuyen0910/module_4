package com.case_study.repository.employee;

import com.case_study.model.employee.Divisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IDivisionRepository extends JpaRepository<Divisions, Integer> {
//    @Query(value = "select * from division", nativeQuery = true)
//    List<Divisions> findAll();
}
