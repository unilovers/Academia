package com.unilopers.academia.controller;

import com.unilopers.academia.dto.PlanoDTO;
import com.unilopers.academia.model.Plano;
import com.unilopers.academia.service.PlanoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/planos")
public class PlanoController {
    private final PlanoService service;
    public PlanoController(PlanoService service) { this.service = service; }

    @GetMapping public ResponseEntity<List<PlanoDTO>> listar() { return ResponseEntity.ok(service.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<PlanoDTO> obter(@PathVariable Long id) { return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @PostMapping public ResponseEntity<PlanoDTO> criar(@RequestBody Plano plano) { PlanoDTO dto = service.create(plano); return ResponseEntity.created(URI.create("/api/planos/" + dto.getId())).body(dto); }
    @PutMapping("/{id}") public ResponseEntity<PlanoDTO> atualizar(@PathVariable Long id, @RequestBody Plano plano) { return service.update(id, plano).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> apagar(@PathVariable Long id) { boolean removed = service.delete(id); return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); }
}
