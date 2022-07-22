package com.example.service;


import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductManagementService {
    List<Product> findAll();

    void save(Product product);

    Optional<Product> findById(Integer id);

    void update(int id, Product product);

    void remove(int id);

    Page<Product> findAll(Pageable pageable);

    Page<Product> findByNameContaining(String name, Pageable pageable);
}
