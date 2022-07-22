package com.example.validate_from.service;

import com.example.validate_from.model.Register;
import com.example.validate_from.repository.IRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService implements IRegisterService {
    @Autowired
    private IRegisterRepository registerRepository;

    @Override
    public List<Register> findAll() {
        return registerRepository.findAll();
    }

    @Override
    public void save(Register register) {
        registerRepository.save(register);
    }
}
