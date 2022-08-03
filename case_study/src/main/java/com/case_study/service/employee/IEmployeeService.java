package com.case_study.service.employee;

import com.case_study.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Optional<Employee> findById(int employeeId);

    void update(int employeeId, Employee employee);

    void remove(int employeeId);

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByNameContaining(String employeeName, Pageable pageable);
}
