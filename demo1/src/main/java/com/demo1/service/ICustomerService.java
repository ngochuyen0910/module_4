package com.demo1.service;

import com.demo1.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);
}
