package com.example.sports_api.repository;

import com.example.sports_api.model.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModalidadeRepository extends JpaRepository<Modalidade, Long> {
}
