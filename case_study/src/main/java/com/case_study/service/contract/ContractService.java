package com.case_study.service.contract;

import com.case_study.model.contract.Contract;
import com.case_study.repository.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public Optional<Contract> findById(int contractId) {
        return contractRepository.findById(contractId);
    }

    @Override
    public void update(int contractId, Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(int contractId) {
        contractRepository.deleteById(contractId);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }
}
