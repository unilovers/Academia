package com.unilopers.academia.controller;

import com.unilopers.academia.model.ItemMatricula;
import com.unilopers.academia.service.ItemMatriculaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item-matricula")
public class ItemMatriculaController {

    private final ItemMatriculaService service;

    public ItemMatriculaController(ItemMatriculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<ItemMatricula> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ItemMatricula findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ItemMatricula save(@RequestBody ItemMatricula item) {
        return service.save(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
