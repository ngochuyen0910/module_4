package com.spring_security_database.service;

import com.spring_security_database.model.User;

public interface UserService {
    User findByUsername(String username);
}
