package com.demo1.repository;

import com.demo1.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction, String> {
    @Query(value = "select transaction.* from transaction left join customer c on transaction.customer_id = c.customer_id where c.name like :search and transaction_type like :searchss",
            nativeQuery = true)
    List<Transaction> findByNameContaining(@Param("search") String name, @Param("searchss") String transaction_type);
}
