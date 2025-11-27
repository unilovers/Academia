package com.unilopers.academia.service;

import com.unilopers.academia.dto.MatriculaDTO;
import com.unilopers.academia.model.Aluno;
import com.unilopers.academia.model.Matricula;
import com.unilopers.academia.model.Plano;
import com.unilopers.academia.repository.AlunoRepository;
import com.unilopers.academia.repository.MatriculaRepository;
import com.unilopers.academia.repository.PlanoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatriculaService {

    private final MatriculaRepository repo;
    private final AlunoRepository alunoRepo;
    private final PlanoRepository planoRepo;

    public MatriculaService(MatriculaRepository repo, AlunoRepository alunoRepo, PlanoRepository planoRepo) {
        this.repo = repo; this.alunoRepo = alunoRepo; this.planoRepo = planoRepo;
    }

    private MatriculaDTO toDTO(Matricula m) {
        return new MatriculaDTO(m.getId(), m.getAluno().getId(), m.getPlano().getId(), m.getDataInicio(), m.getDataFim(), m.getAtiva());
    }

    public List<MatriculaDTO> findAll() { return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList()); }
    public Optional<MatriculaDTO> findById(Long id) { return repo.findById(id).map(this::toDTO); }
    public List<MatriculaDTO> findByAluno(Long alunoId) { return repo.findByAlunoId(alunoId).stream().map(this::toDTO).collect(Collectors.toList()); }

    public Optional<MatriculaDTO> create(Long alunoId, Long planoId, Matricula matricula) {
        Optional<Aluno> a = alunoRepo.findById(alunoId);
        Optional<Plano> p = planoRepo.findById(planoId);
        if (a.isPresent() && p.isPresent()) {
            matricula.setAluno(a.get());
            matricula.setPlano(p.get());
            return Optional.of(toDTO(repo.save(matricula)));
        }
        return Optional.empty();
    }

    public Optional<MatriculaDTO> update(Long id, Matricula updated) {
        return repo.findById(id).map(existing -> {
            existing.setDataInicio(updated.getDataInicio());
            existing.setDataFim(updated.getDataFim());
            existing.setAtiva(updated.getAtiva());
            return toDTO(repo.save(existing));
        });
    }

    public boolean delete(Long id) { return repo.findById(id).map(m -> { repo.delete(m); return true; }).orElse(false); }
}
