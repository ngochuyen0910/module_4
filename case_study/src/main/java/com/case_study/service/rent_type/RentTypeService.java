package com.case_study.service.rent_type;

import com.case_study.model.facility.RentType;
import com.case_study.repository.facility.IRentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentRepository rentRepository;

    @Override
    public List<RentType> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public void save(RentType rentType) {
        rentRepository.save(rentType);
    }
}
