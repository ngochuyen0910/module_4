package com.example.validate_from.repository;

import com.example.validate_from.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegisterRepository extends JpaRepository<Register, Integer> {

}
