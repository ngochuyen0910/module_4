package com.restful_blog.repository;

import com.restful_blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUserName(String name);
}
