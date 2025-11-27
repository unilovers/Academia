package com.unilopers.academia.service;

import com.unilopers.academia.model.ItemMatricula;
import com.unilopers.academia.repository.ItemMatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemMatriculaService {

    private final ItemMatriculaRepository repository;

    public ItemMatriculaService(ItemMatriculaRepository repository) {
        this.repository = repository;
    }

    public List<ItemMatricula> findAll() {
        return repository.findAll();
    }

    public ItemMatricula findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ItemMatricula save(ItemMatricula item) {
        return repository.save(item);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
