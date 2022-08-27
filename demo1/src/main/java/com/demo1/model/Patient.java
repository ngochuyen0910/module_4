package com.demo1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<MedicalRecord> medicalRecord;

    public Patient() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MedicalRecord> getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(Set<MedicalRecord> medicalRecord) {
        this.medicalRecord = medicalRecord;
    }
}
