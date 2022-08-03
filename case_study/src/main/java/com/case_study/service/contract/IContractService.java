package com.case_study.service.contract;

import com.case_study.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IContractService {
    List<Contract> findAll();

    void save(Contract contract);

    Optional<Contract> findById(int contractId);

    void update(int contractId, Contract contract);

    void remove(int contractId);

    Page<Contract> findAll(Pageable pageable);

}
