package com.example.repository;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductManagementRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where name_product like :search", nativeQuery= true)
    Page<Product> findByNameContaining(@Param("search") String name, Pageable pageable);
}
