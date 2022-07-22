package com.example.validate_from.service;

import com.example.validate_from.model.Register;

import java.util.List;

public interface IRegisterService {
    List<Register> findAll();

    void save(Register register);
}
