package com.demo1.service;

import com.demo1.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<Patient> findAll();

    void save(Patient patient);

    Optional<Patient> findById(Integer id);

}
