package com.example.sports_api.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Atleta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer idade;

    @ManyToOne
    @JoinColumn(name = "modalidade_id")
    private Modalidade modalidade;
}
