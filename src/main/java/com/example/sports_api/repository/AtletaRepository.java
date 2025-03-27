package com.example.sports_api.repository;

import com.example.sports_api.model.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {
}
