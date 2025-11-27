package com.unilopers.academia.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PagamentoDTO {
    private Long id;
    private Long alunoId;
    private BigDecimal valor;
    private LocalDate dataPagamento;
    private String metodo;
    private String referencia;


    public PagamentoDTO(Long id, Long alunoId, BigDecimal valor, LocalDate dataPagamento, String metodo, String referencia) {
        this.id = id; this.alunoId = alunoId; this.valor = valor; this.dataPagamento = dataPagamento; this.metodo = metodo; this.referencia = referencia;
    }

    public PagamentoDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(Long alunoId) {
        this.alunoId = alunoId;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
