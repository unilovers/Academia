package com.unilopers.academia.dto;

import java.math.BigDecimal;

public class PlanoDTO {
    private Long id;
    private String nome;
    private Integer duracaoMeses;
    private BigDecimal valor;
    private String descricao;


    public PlanoDTO(Long id, String nome, Integer duracaoMeses, BigDecimal valor, String descricao) {
        this.id = id;
        this.nome = nome;
        this.duracaoMeses = duracaoMeses;
        this.valor = valor;
        this.descricao = descricao;
    }

    public PlanoDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDuracaoMeses() {
        return duracaoMeses;
    }

    public void setDuracaoMeses(Integer duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
