package com.demo1.service;

import com.demo1.model.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MedicalRecordService {
    Page<MedicalRecord> findAll(Pageable pageable);

    Page<MedicalRecord> search(String name, String doctor, Pageable pageable);

    Optional<MedicalRecord> findById(Integer id);

    void save(MedicalRecord MedicalRecord);

    void update(MedicalRecord MedicalRecord);

    void delete(Integer id);
}
