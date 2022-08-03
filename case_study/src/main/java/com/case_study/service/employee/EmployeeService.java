package com.case_study.service.employee;

import com.case_study.model.employee.Employee;
import com.case_study.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findById(int employeeId) {
        return employeeRepository.findById(employeeId);
    }

    @Override
    public void update(int employeeId, Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        Page<Employee> temp = employeeRepository.findAll(pageable);
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> findByNameContaining(String employeeName, Pageable pageable) {
        return null;
    }
}
