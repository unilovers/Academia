package com.unilopers.academia.service;

import com.unilopers.academia.model.NotaFiscal;
import com.unilopers.academia.repository.NotaFiscalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaFiscalService {

    private final NotaFiscalRepository repository;

    public NotaFiscalService(NotaFiscalRepository repository) {
        this.repository = repository;
    }

    public List<NotaFiscal> findAll() {
        return repository.findAll();
    }

    public NotaFiscal findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public NotaFiscal save(NotaFiscal nota) {
        return repository.save(nota);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
