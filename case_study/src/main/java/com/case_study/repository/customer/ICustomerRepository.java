package com.case_study.repository.customer;

import com.case_study.model.customer.Customer;
import com.case_study.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    //@Query(value = "select * from customer where customer_name like :search",nativeQuery = true);
//    Page<Customer> findByCustomerNameContaining(@Param("search") String customerTypeName, Pageable pageable);

    @Query(value = "select * from customer where delete_status=false", nativeQuery = true)
    Page<Customer> findAll(Pageable pageable);
    @Modifying
    @Query(value = "update customer set delete_status=true where customerId=:id", nativeQuery = true)
    void remove(@Param("id") int id);
}

