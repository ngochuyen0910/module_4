package com.case_study.service.rent_type;

import com.case_study.model.facility.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();

    void save(RentType rentType);
}
