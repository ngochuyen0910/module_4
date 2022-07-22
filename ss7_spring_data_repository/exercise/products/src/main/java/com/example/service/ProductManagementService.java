package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductManagementService implements IProductManagementService {
    @Autowired
    private IProductManagementRepository productManagementRepository;

    @Override
    public List<Product> findAll() {
        return productManagementRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productManagementRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productManagementRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productManagementRepository.save(product);
    }

    @Override
    public void remove(int id) {
        productManagementRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productManagementRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findByNameContaining(String name, Pageable pageable) {
        return productManagementRepository.findByNameContaining(name, pageable);
    }
}

