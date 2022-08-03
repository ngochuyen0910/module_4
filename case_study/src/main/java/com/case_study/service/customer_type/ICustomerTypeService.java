package com.case_study.service.customer_type;

import com.case_study.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();

    void save(CustomerType customerType);
}
