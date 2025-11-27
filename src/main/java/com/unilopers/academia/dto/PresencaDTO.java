package com.unilopers.academia.dto;

import java.time.LocalDateTime;

public class PresencaDTO {
    private Long id;
    private Long alunoId;
    private LocalDateTime entrada;
    private LocalDateTime saida;
    private String observacao;


    public PresencaDTO(Long id, Long alunoId, LocalDateTime entrada, LocalDateTime saida, String observacao) {
        this.id = id; this.alunoId = alunoId; this.entrada = entrada; this.saida = saida; this.observacao = observacao;
    }

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

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
