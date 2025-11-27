package com.unilopers.academia.service;

import com.unilopers.academia.dto.PresencaDTO;
import com.unilopers.academia.model.Aluno;
import com.unilopers.academia.model.Presenca;
import com.unilopers.academia.repository.AlunoRepository;
import com.unilopers.academia.repository.PresencaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PresencaService {

    private final PresencaRepository repo;
    private final AlunoRepository alunoRepo;

    public PresencaService(PresencaRepository repo, AlunoRepository alunoRepo) {
        this.repo = repo;
        this.alunoRepo = alunoRepo;
    }

    private PresencaDTO toDTO(Presenca p) {
        return new PresencaDTO(p.getId(), p.getAluno().getId(), p.getEntrada(), p.getSaida(), p.getObservacao());
    }

    public List<PresencaDTO> findAll() { return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList()); }
    public Optional<PresencaDTO> findById(Long id) { return repo.findById(id).map(this::toDTO); }
    public List<PresencaDTO> findByAluno(Long alunoId) { return repo.findByAlunoIdOrderByEntradaDesc(alunoId).stream().map(this::toDTO).collect(Collectors.toList()); }

    public Optional<PresencaDTO> create(Long alunoId, Presenca presenca) {
        return alunoRepo.findById(alunoId).map(aluno -> {
            presenca.setAluno(aluno);
            return toDTO(repo.save(presenca));
        });
    }

    public Optional<PresencaDTO> update(Long id, Presenca updated) {
        return repo.findById(id).map(existing -> {
            existing.setEntrada(updated.getEntrada());
            existing.setSaida(updated.getSaida());
            existing.setObservacao(updated.getObservacao());
            return toDTO(repo.save(existing));
        });
    }

    public boolean delete(Long id) {
        return repo.findById(id).map(p -> { repo.delete(p); return true; }).orElse(false);
    }
}
