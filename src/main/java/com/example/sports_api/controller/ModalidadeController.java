package com.example.sports_api.controller;

import com.example.sports_api.model.Modalidade;
import com.example.sports_api.repository.ModalidadeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modalidades")
public class ModalidadeController {

    private final ModalidadeRepository modalidadeRepository;

    public ModalidadeController(ModalidadeRepository modalidadeRepository) {
        this.modalidadeRepository = modalidadeRepository;
    }

    @GetMapping
    public List<Modalidade> listarTodas() {
        return modalidadeRepository.findAll();
    }

    @PostMapping
    public Modalidade criar(@RequestBody Modalidade modalidade) {
        return modalidadeRepository.save(modalidade);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modalidade> atualizar(@PathVariable Long id, @RequestBody Modalidade modalidadeAtualizada) {
        return modalidadeRepository.findById(id)
                .map(modalidade -> {
                    modalidade.setNome(modalidadeAtualizada.getNome());
                    return ResponseEntity.ok(modalidadeRepository.save(modalidade));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return modalidadeRepository.findById(id)
                .map(modalidade -> {
                    modalidadeRepository.delete(modalidade);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
