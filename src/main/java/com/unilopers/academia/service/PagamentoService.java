package com.unilopers.academia.service;

import com.unilopers.academia.dto.PagamentoDTO;
import com.unilopers.academia.model.Aluno;
import com.unilopers.academia.model.Pagamento;
import com.unilopers.academia.repository.AlunoRepository;
import com.unilopers.academia.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    private final PagamentoRepository repo;
    private final AlunoRepository alunoRepo;

    public PagamentoService(PagamentoRepository repo, AlunoRepository alunoRepo) {
        this.repo = repo;
        this.alunoRepo = alunoRepo;
    }

    private PagamentoDTO toDTO(Pagamento p) {
        return new PagamentoDTO(p.getId(), p.getAluno().getId(), p.getValor(), p.getDataPagamento(), p.getMetodo(), p.getReferencia());
    }

    public List<PagamentoDTO> findAll() { return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList()); }
    public Optional<PagamentoDTO> findById(Long id) { return repo.findById(id).map(this::toDTO); }
    public List<PagamentoDTO> findByAluno(Long alunoId) { return repo.findByAlunoId(alunoId).stream().map(this::toDTO).collect(Collectors.toList()); }

    public Optional<PagamentoDTO> create(Long alunoId, Pagamento pagamento) {
        return alunoRepo.findById(alunoId).map(aluno -> {
            pagamento.setAluno(aluno);
            return toDTO(repo.save(pagamento));
        });
    }

    public Optional<PagamentoDTO> update(Long id, Pagamento updated) {
        return repo.findById(id).map(existing -> {
            existing.setValor(updated.getValor());
            existing.setDataPagamento(updated.getDataPagamento());
            existing.setMetodo(updated.getMetodo());
            existing.setReferencia(updated.getReferencia());
            return toDTO(repo.save(existing));
        });
    }

    public boolean delete(Long id) {
        return repo.findById(id).map(p -> { repo.delete(p); return true; }).orElse(false);
    }
}
