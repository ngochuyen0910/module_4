package com.test.service;

import com.test.model.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ITinTucService {
    Page<TinTuc> findAll(Pageable pageable);

    void save(TinTuc tinTuc);

    Optional<TinTuc> findById(int tinTucId);

    void remove(int tinTucId);

    Page<TinTuc> findByNameContaining(String name, String title, Pageable pageable);
}
