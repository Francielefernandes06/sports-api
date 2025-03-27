package com.example.sports_api.controller;

import com.example.sports_api.model.Atleta;
import com.example.sports_api.model.Modalidade;
import com.example.sports_api.repository.AtletaRepository;
import com.example.sports_api.repository.ModalidadeRepository;
import com.example.sports_api.service.AtletaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atletas")
public class AtletaController {

    private final AtletaRepository atletaRepository;
    private final ModalidadeRepository modalidadeRepository;
    private final AtletaService atletaService;


    public AtletaController(AtletaRepository atletaRepository, ModalidadeRepository modalidadeRepository, AtletaService atletaService) {
        this.atletaRepository = atletaRepository;
        this.modalidadeRepository = modalidadeRepository;
        this.atletaService = atletaService;
    }

    @GetMapping
    public List<Atleta> listarTodos() {
        return atletaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Atleta> criarAtleta(@RequestBody Atleta atleta) {
        // Carregar a modalidade com o ID recebido
        Optional<Modalidade> modalidadeOptional = modalidadeRepository.findById(atleta.getModalidade().getId());
        
        if (!modalidadeOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Caso a modalidade não seja encontrada
        }
        
        Atleta novoAtleta = new Atleta();
        novoAtleta.setNome(atleta.getNome());
        novoAtleta.setIdade(atleta.getIdade());
        novoAtleta.setModalidade(modalidadeOptional.get());

        Atleta criadoAtleta = atletaService.salvarAtleta(novoAtleta);
        return ResponseEntity.status(HttpStatus.CREATED).body(criadoAtleta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atleta> atualizar(@PathVariable Long id, @RequestBody Atleta atletaAtualizado) {
        return atletaRepository.findById(id)
                .map(atleta -> {
                    atleta.setNome(atletaAtualizado.getNome());
                    atleta.setIdade(atletaAtualizado.getIdade());
                    atleta.setModalidade(atletaAtualizado.getModalidade());
                    return ResponseEntity.ok(atletaRepository.save(atleta));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return atletaRepository.findById(id)
                .map(atleta -> {
                    atletaRepository.delete(atleta);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
