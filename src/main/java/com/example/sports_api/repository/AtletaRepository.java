package com.example.sports_api.repository;

import com.example.sports_api.model.Atleta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {
    Page<Atleta> findAll(Pageable pageable);

}
