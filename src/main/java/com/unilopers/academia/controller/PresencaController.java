package com.unilopers.academia.controller;

import com.unilopers.academia.dto.PresencaDTO;
import com.unilopers.academia.model.Presenca;
import com.unilopers.academia.service.PresencaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/presencas")
public class PresencaController {

    private final PresencaService service;

    public PresencaController(PresencaService service) { this.service = service; }

    @GetMapping public ResponseEntity<List<PresencaDTO>> listar() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<PresencaDTO> obter(@PathVariable Long id) { return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @GetMapping("/aluno/{alunoId}") public ResponseEntity<List<PresencaDTO>> porAluno(@PathVariable Long alunoId) { return ResponseEntity.ok(service.findByAluno(alunoId)); }

    @PostMapping("/aluno/{alunoId}")
    public ResponseEntity<PresencaDTO> criar(@PathVariable Long alunoId, @RequestBody Presenca presenca) {
        return service.create(alunoId, presenca)
                .map(dto -> ResponseEntity.created(URI.create("/api/presencas/" + dto.getId())).body(dto))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}") public ResponseEntity<PresencaDTO> atualizar(@PathVariable Long id, @RequestBody Presenca presenca) { return service.update(id, presenca).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> apagar(@PathVariable Long id) { boolean removed = service.delete(id); return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
}
