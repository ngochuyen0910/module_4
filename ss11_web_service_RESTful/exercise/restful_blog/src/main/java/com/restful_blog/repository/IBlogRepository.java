package com.restful_blog.repository;

import com.restful_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where name_blog like :search", nativeQuery= true)
    List<Blog> findByName(@Param("search") String nameBlog);
}
