package com.case_study.repository.facility;

import com.case_study.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentRepository extends JpaRepository<RentType, Integer> {
}
