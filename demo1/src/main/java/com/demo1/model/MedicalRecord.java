package com.demo1.model;

import javax.persistence.*;

@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String hospitalizedDay;
    private String hospitalDischargeDate;
    @Column(name = "`reason`")
    private String reason;
    @Column(name = "`method`")
    private String method;
    private String doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    public MedicalRecord() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHospitalizedDay() {
        return hospitalizedDay;
    }


    public void setHospitalizedDay(String hospitalizedDay) {
        this.hospitalizedDay = hospitalizedDay;
    }

    public String getHospitalDischargeDate() {
        return hospitalDischargeDate;
    }

    public void setHospitalDischargeDate(String hospitalDischargeDate) {
        this.hospitalDischargeDate = hospitalDischargeDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

