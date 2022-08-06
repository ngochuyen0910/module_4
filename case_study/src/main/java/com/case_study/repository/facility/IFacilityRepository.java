package com.case_study.repository.facility;

import com.case_study.model.customer.Customer;
import com.case_study.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    @Query(value = "select * from facility where delete_status=false", nativeQuery = true)
    Page<Facility> findAll(Pageable pageable);

    @Modifying
    @Query(value = "update facility set delete_status=true where facilityId=:id", nativeQuery = true)
    void remove(@Param("id") int id);

}
