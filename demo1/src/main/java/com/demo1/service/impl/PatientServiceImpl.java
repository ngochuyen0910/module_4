package com.demo1.service.impl;

import com.demo1.model.Patient;
import com.demo1.repository.PatientRepository;
import com.demo1.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }
}
