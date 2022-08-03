package com.case_study.repository.customer;

import com.case_study.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    //@Query(value = "select * from customer where customer_name like :search",nativeQuery = true);
    Page<Customer> findByCustomerNameContaining(@Param("search") String customerTypeName, Pageable pageable);

}
