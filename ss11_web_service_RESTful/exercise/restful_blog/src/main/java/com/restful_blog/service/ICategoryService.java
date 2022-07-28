package com.restful_blog.service;

import com.restful_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void update(int id, Category category);

    void remove(Integer id);
}