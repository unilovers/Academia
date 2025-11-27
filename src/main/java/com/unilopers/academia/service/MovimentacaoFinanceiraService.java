package com.unilopers.academia.service;

import com.unilopers.academia.model.MovimentacaoFinanceira;
import com.unilopers.academia.repository.MovimentacaoFinanceiraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoFinanceiraService {

    private final MovimentacaoFinanceiraRepository repository;

    public MovimentacaoFinanceiraService(MovimentacaoFinanceiraRepository repository) {
        this.repository = repository;
    }

    public List<MovimentacaoFinanceira> findAll() {
        return repository.findAll();
    }

    public MovimentacaoFinanceira findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public MovimentacaoFinanceira save(MovimentacaoFinanceira mov) {
        return repository.save(mov);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
