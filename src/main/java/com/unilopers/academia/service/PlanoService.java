package com.unilopers.academia.service;

import com.unilopers.academia.dto.PlanoDTO;
import com.unilopers.academia.model.Plano;
import com.unilopers.academia.repository.PlanoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlanoService {
    private final PlanoRepository repo;
    public PlanoService(PlanoRepository repo) { this.repo = repo; }
    private PlanoDTO toDTO(Plano p) {
        return new PlanoDTO(p.getId(), p.getNome(), p.getDuracaoMeses(), p.getValor(), p.getDescricao());
    }
    public List<PlanoDTO> findAll() { return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList()); }
    public Optional<PlanoDTO> findById(Long id) { return repo.findById(id).map(this::toDTO); }
    public PlanoDTO create(Plano plano) { return toDTO(repo.save(plano)); }
    public Optional<PlanoDTO> update(Long id, Plano updated) {
        return repo.findById(id).map(existing -> {
            existing.setNome(updated.getNome());
            existing.setDuracaoMeses(updated.getDuracaoMeses());
            existing.setValor(updated.getValor());
            existing.setDescricao(updated.getDescricao());
            return toDTO(repo.save(existing));
        });
    }
    public boolean delete(Long id) {
        return repo.findById(id).map(p -> { repo.delete(p); return true; }).orElse(false);
    }
}
