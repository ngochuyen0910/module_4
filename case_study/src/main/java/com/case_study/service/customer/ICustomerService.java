package com.case_study.service.customer;

import com.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Optional<Customer> findById(int customerId);

    void update(int customerId, Customer customer);

    void remove(int customerId);

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByNameContaining(String customerName, Pageable pageable);
}
