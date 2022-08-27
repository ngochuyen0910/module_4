package com.demo1.service.impl;

import com.demo1.model.MedicalRecord;
import com.demo1.repository.MedicalRecordRepository;
import com.demo1.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {
    @Autowired
    MedicalRecordRepository medicalRecordRepository;

    @Override
    public List<MedicalRecord> findAll() {
        return medicalRecordRepository.findAll();
    }

    @Override
    public void save(MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord.getPatient().getId(), medicalRecord.getHospitalizedDay(), medicalRecord.getHospitalDischargeDate(),
                medicalRecord.getReason(), medicalRecord.getMethod(), medicalRecord.getDoctor());
    }

    @Override
    public void update(MedicalRecord medicalRecord) {
        medicalRecordRepository.update(medicalRecord.getHospitalizedDay(), medicalRecord.getHospitalDischargeDate(),
                medicalRecord.getReason(), medicalRecord.getMethod(), medicalRecord.getDoctor(), medicalRecord.getId());
    }

    @Override
    public void delete(Integer id) {
        medicalRecordRepository.deleteById(id);
    }

    @Override
    public Optional<MedicalRecord> findById(Integer id) {
        return medicalRecordRepository.findById(id);
    }
}
