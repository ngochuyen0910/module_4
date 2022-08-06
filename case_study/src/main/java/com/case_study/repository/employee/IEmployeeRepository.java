package com.case_study.repository.employee;

import com.case_study.model.employee.Employee;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from employee where delete_status = false ", nativeQuery = true)
    Page<Employee> findAll(Pageable pageable);

    @Modifying
    @Query(value = "update employee set delete_status = true where employeeId=:id", nativeQuery = true)
    void remove(@Param("id") int id);
}
