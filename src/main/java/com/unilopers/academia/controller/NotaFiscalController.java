package com.unilopers.academia.controller;

import com.unilopers.academia.model.NotaFiscal;
import com.unilopers.academia.service.NotaFiscalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nota-fiscal")
public class NotaFiscalController {

    private final NotaFiscalService service;

    public NotaFiscalController(NotaFiscalService service) {
        this.service = service;
    }

    @GetMapping
    public List<NotaFiscal> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public NotaFiscal findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public NotaFiscal save(@RequestBody NotaFiscal nota) {
        return service.save(nota);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
