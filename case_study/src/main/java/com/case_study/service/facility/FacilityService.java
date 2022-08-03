package com.case_study.service.facility;

import com.case_study.model.facility.Facility;
import com.case_study.repository.facility.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        if (facility.getFacilityType().getFacilityTypeId() == 1) {
            facility.setFacilityFree(null);
        } else if (facility.getFacilityType().getFacilityTypeId() == 2) {
            facility.setPoolArea(0.0);
            facility.setFacilityFree(null);
        } else {
            facility.setPoolArea(0.0);
            facility.setStandardRoom(null);
            facility.setDescriptionOtherConvenience(null);
            facility.setNumberOfFloors(0);
        }
        facilityRepository.save(facility);
    }

    @Override
    public Optional<Facility> findById(int facilityId) {
        return facilityRepository.findById(facilityId);
    }

    @Override
    public void update(int facilityId, Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(int facilityId) {
        facilityRepository.deleteById(facilityId);
    }

    @Override
    public Page<Facility> findAll(Pageable pageable) {
        List<Facility> facilityList = facilityRepository.findAll();
        return facilityRepository.findAll(pageable);
    }
}
