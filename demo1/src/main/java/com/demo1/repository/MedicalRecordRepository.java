package com.demo1.repository;

import com.demo1.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {

    @Query(value = "select * from patient limit :page, 5", nativeQuery = true)
    List<MedicalRecord> findAllPage(@Param("page") Integer page);

    @Query(value = "select * from medical_record", nativeQuery = true)
    List<MedicalRecord> findAll();

    @Query(value = "select * from medical_record where id = :id", nativeQuery = true)
    Optional<MedicalRecord> findById(@Param("id") Integer id);

    @Query(value = "select medical_record.* from medical_record join patient on medical_record.patient_id = medical_record.id " +
            " where medical_record.doctor like %:doctor% and patienter.name like %:name% and medical_record.reason like %:reason% " +
            " and medical_record.method like %:method% limit :page, 5", nativeQuery = true)
    List<MedicalRecord> search(@Param("doctor") String doctor, @Param("name") String name, @Param("reason") String reason, @Param("method") String method, @Param("page") Integer page);

    @Modifying
    @Transactional
    @Query(value = "insert into medical_record(patient_id, hospitalized_day, hospital_discharge_date, reason, method, doctor) " +
            " values (:patienterId, :hospitalizedDay, :hospitalDischargeDate, :reason, :method, :doctor );", nativeQuery = true)
    void save(@Param("patienterId") Integer patienterId, @Param("hospitalizedDay") String hospitalizedDay,
              @Param("hospitalDischargeDate") String hospitalDischargeDate, @Param("reason") String reason, @Param("method") String method, @Param("doctor") String doctor);

    @Transactional
    @Modifying
    @Query(value = "update medical_record set hospitalized_day = :hospitalizedDay, hospital_discharge_date = :hospitalDischargeDate, " +
            " reason = :reason, method = :method, doctor = :doctor where id = :id", nativeQuery = true)
    void update(@Param("hospitalizedDay") String hospitalizedDay, @Param("hospitalDischargeDate") String hospitalDischargeDate,
                @Param("reason") String reason, @Param("method") String method, @Param("doctor") String doctor, @Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "delete from medical_record where id = :id", nativeQuery = true)
    void delete(@Param("id") Integer id);
}
