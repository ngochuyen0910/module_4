package com.example.service;

import com.example.model.Blog;
import com.example.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    Optional<Category> findById(Integer id);

    void save(Category category);

    void update(int id, Category category);

    void remove(Integer id);
}
