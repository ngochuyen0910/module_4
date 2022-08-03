package com.case_study.service.facility_type;

import com.case_study.model.facility.FacilityType;

import java.util.List;

public interface IFacilityTypeService {
    List<FacilityType> findAll();

    void save(FacilityType facilityType);
}
