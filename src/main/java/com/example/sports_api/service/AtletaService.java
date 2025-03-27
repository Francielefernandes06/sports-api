package com.example.sports_api.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.sports_api.model.Atleta;
import com.example.sports_api.repository.AtletaRepository;
import org.springframework.stereotype.Service;

@Service

public class AtletaService {
    
     @Autowired
    private AtletaRepository atletaRepository;

    public Atleta salvarAtleta(Atleta atleta) {
        return atletaRepository.save(atleta);
    }
}
