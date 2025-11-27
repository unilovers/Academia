package com.unilopers.academia.dto;

import java.time.LocalDate;

public class MatriculaDTO {
    private Long id;
    private Long alunoId;
    private Long planoId;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Boolean ativa;


    public MatriculaDTO(Long id, Long alunoId, Long planoId, LocalDate dataInicio, LocalDate dataFim, Boolean ativa) {
        this.id = id; this.alunoId = alunoId; this.planoId = planoId; this.dataInicio = dataInicio; this.dataFim = dataFim; this.ativa = ativa;
    }

    public MatriculaDTO() {}

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

    public Long getPlanoId() {
        return planoId;
    }

    public void setPlanoId(Long planoId) {
        this.planoId = planoId;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

}
