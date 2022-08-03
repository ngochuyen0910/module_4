package com.case_study.service.facility;

import com.case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    List<Facility> findAll();

    void save(Facility facility);

    Optional<Facility> findById(int facilityId);

    void update(int facilityId, Facility facility);

    void remove(int facilityId);

    Page<Facility> findAll(Pageable pageable);
}
