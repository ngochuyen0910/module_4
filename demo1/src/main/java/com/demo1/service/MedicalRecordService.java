package com.demo1.service;

import com.demo1.model.MedicalRecord;

import java.util.List;
import java.util.Optional;

public interface MedicalRecordService {
    List<MedicalRecord> findAll();

    List<MedicalRecord> findAllPage(Integer page);

    List<MedicalRecord> search(String doctor, String name, String reason, String method, Integer page);

    Optional<MedicalRecord> findById(Integer id);

    void save(MedicalRecord MedicalRecord);

    void update(MedicalRecord MedicalRecord);

    void delete(Integer id);
}
