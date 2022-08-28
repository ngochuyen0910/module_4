package com.demo1.controller;

import com.demo1.model.MedicalRecord;
import com.demo1.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/medicalRecord")
public class MedicalRecordController {
    @Autowired
    private MedicalRecordService medicalRecordService;

    @GetMapping
    public ResponseEntity<Page<MedicalRecord>> getAll(@PageableDefault(value = 3) Pageable pageable) {
        return new ResponseEntity<>(medicalRecordService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MedicalRecord> create(@RequestBody MedicalRecord medicalRecord) {
        medicalRecordService.save(medicalRecord);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> findById(@PathVariable Integer id) {
        Optional<MedicalRecord> medicalRecord = medicalRecordService.findById(id);
        if (!medicalRecordService.findById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(medicalRecord.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MedicalRecord> delete(@PathVariable Integer id) {
        Optional<MedicalRecord> medicalRecord = medicalRecordService.findById(id);
        if (!medicalRecord.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        medicalRecordService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicalRecord> update(@PathVariable Integer id,
                                                 @RequestBody MedicalRecord medicalRecord) {
        MedicalRecord currentMedicalRecord = medicalRecordService.findById(id).get();
        if (currentMedicalRecord == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentMedicalRecord.setId(medicalRecord.getId());
        currentMedicalRecord.setHospitalizedDay(medicalRecord.getHospitalizedDay());
        currentMedicalRecord.setHospitalDischargeDate(medicalRecord.getHospitalDischargeDate());
        currentMedicalRecord.setReason(medicalRecord.getReason());
        currentMedicalRecord.setMethod(medicalRecord.getMethod());
        currentMedicalRecord.setDoctor(medicalRecord.getDoctor());
        currentMedicalRecord.setPatient(medicalRecord.getPatient());

        medicalRecordService.update(currentMedicalRecord);
        return new ResponseEntity<>(currentMedicalRecord, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<MedicalRecord>> search(@RequestParam String search,@RequestParam String searchss,  @PageableDefault(value = 3) Pageable pageable) {
        return new ResponseEntity<>(medicalRecordService.search(search,searchss, pageable), HttpStatus.OK);
    }
}

