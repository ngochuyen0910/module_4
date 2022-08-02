package com.example.repository;

import com.example.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Locale;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
