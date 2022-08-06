package com.demo1.repository;

import com.demo1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
}
