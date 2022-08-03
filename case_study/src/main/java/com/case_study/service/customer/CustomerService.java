package com.case_study.service.customer;

import com.case_study.model.customer.Customer;
import com.case_study.repository.customer.ICustomerRepository;
import com.case_study.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(int customerId) {
        return customerRepository.findById(customerId);
    }

    @Override
    public void update(int customerId, Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(int customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        Page<Customer> temp = customerRepository.findAll(pageable);
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByNameContaining(String customerName, Pageable pageable) {
        return null;
    }
}