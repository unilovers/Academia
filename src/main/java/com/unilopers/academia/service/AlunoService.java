package com.unilopers.academia.service;

import com.unilopers.academia.dto.AlunoDTO;
import com.unilopers.academia.model.Aluno;
import com.unilopers.academia.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository repo;

    public AlunoService(AlunoRepository repo) {
        this.repo = repo;
    }

    private AlunoDTO toDTO(Aluno a) {
        return new AlunoDTO(a.getId(), a.getNome(), a.getEmail(), a.getTelefone(), a.getDataNascimento(), a.getAtivo());
    }

    public List<AlunoDTO> findAll() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<AlunoDTO> findById(Long id) {
        return repo.findById(id).map(this::toDTO);
    }

    public AlunoDTO create(Aluno aluno) {
        Aluno saved = repo.save(aluno);
        return toDTO(saved);
    }

    public Optional<AlunoDTO> update(Long id, Aluno updated) {
        return repo.findById(id).map(existing -> {
            existing.setNome(updated.getNome());
            existing.setEmail(updated.getEmail());
            existing.setTelefone(updated.getTelefone());
            existing.setDataNascimento(updated.getDataNascimento());
            existing.setAtivo(updated.getAtivo());
            return toDTO(repo.save(existing));
        });
    }

    public boolean delete(Long id) {
        return repo.findById(id).map(a -> {
            repo.delete(a);
            return true;
        }).orElse(false);
    }
}
