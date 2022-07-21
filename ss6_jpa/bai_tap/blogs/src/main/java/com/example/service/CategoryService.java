package com.example.service;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void update(int id, Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void remove(Integer id) {
        iCategoryRepository.deleteById(id);
    }
}
