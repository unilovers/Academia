package com.unilopers.academia.controller;

import com.unilopers.academia.model.MovimentacaoFinanceira;
import com.unilopers.academia.service.MovimentacaoFinanceiraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoFinanceiraController {

    private final MovimentacaoFinanceiraService service;

    public MovimentacaoFinanceiraController(MovimentacaoFinanceiraService service) {
        this.service = service;
    }

    @GetMapping
    public List<MovimentacaoFinanceira> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public MovimentacaoFinanceira findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public MovimentacaoFinanceira save(@RequestBody MovimentacaoFinanceira mov) {
        return service.save(mov);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
