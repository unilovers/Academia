package com.unilopers.academia.controller;

import com.unilopers.academia.dto.MatriculaDTO;
import com.unilopers.academia.model.Matricula;
import com.unilopers.academia.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {
    private final MatriculaService service;
    public MatriculaController(MatriculaService service) { this.service = service; }

    @GetMapping public ResponseEntity<List<MatriculaDTO>> listar() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<MatriculaDTO> obter(@PathVariable Long id) { return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @GetMapping("/aluno/{alunoId}") public ResponseEntity<List<MatriculaDTO>> porAluno(@PathVariable Long alunoId) { return ResponseEntity.ok(service.findByAluno(alunoId)); }

    @PostMapping("/aluno/{alunoId}/plano/{planoId}")
    public ResponseEntity<MatriculaDTO> criar(@PathVariable Long alunoId, @PathVariable Long planoId, @RequestBody Matricula matricula) {
        return service.create(alunoId, planoId, matricula)
                .map(dto -> ResponseEntity.created(URI.create("/api/matriculas/" + dto.getId())).body(dto))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}") public ResponseEntity<MatriculaDTO> atualizar(@PathVariable Long id, @RequestBody Matricula matricula) { return service.update(id, matricula).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> apagar(@PathVariable Long id) { boolean removed = service.delete(id); return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
}
