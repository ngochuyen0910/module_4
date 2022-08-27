package com.demo1.controller;

import com.demo1.model.Patient;
import com.demo1.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> findAllPatient() {
        return new ResponseEntity<>(patientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Patient> findAllPatient(@PathVariable Integer id) {
        return new ResponseEntity<>(patientService.findById(id).get(), HttpStatus.OK);
    }
}
