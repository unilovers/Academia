package com.unilopers.academia.controller;

import com.unilopers.academia.dto.PagamentoDTO;
import com.unilopers.academia.model.Pagamento;
import com.unilopers.academia.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    private final PagamentoService service;

    public PagamentoController(PagamentoService service) { this.service = service; }

    @GetMapping public ResponseEntity<List<PagamentoDTO>> listar() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<PagamentoDTO> obter(@PathVariable Long id) { return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @GetMapping("/aluno/{alunoId}") public ResponseEntity<List<PagamentoDTO>> porAluno(@PathVariable Long alunoId) { return ResponseEntity.ok(service.findByAluno(alunoId)); }

    @PostMapping("/aluno/{alunoId}")
    public ResponseEntity<PagamentoDTO> criar(@PathVariable Long alunoId, @RequestBody Pagamento pagamento) {
        return service.create(alunoId, pagamento)
                .map(dto -> ResponseEntity.created(URI.create("/api/pagamentos/" + dto.getId())).body(dto))
                .orElse(ResponseEntity.badRequest().build());
    }

    @PutMapping("/{id}") public ResponseEntity<PagamentoDTO> atualizar(@PathVariable Long id, @RequestBody Pagamento pagamento) { return service.update(id, pagamento).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> apagar(@PathVariable Long id) { boolean removed = service.delete(id); return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
}
