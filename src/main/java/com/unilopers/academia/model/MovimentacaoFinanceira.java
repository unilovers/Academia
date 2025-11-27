package com.unilopers.academia.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "movimentacoes_financeiras")
public class MovimentacaoFinanceira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "nota_fiscal_id")
    private NotaFiscal notaFiscal;

    @Column(nullable = false)
    private LocalDate dataMovimentacao;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private String tipo;
    // EX: "ENTRADA" ou "SAIDA"

    @Column
    private String descricao;

    public MovimentacaoFinanceira() {}

    public MovimentacaoFinanceira(Aluno aluno, NotaFiscal notaFiscal, LocalDate dataMovimentacao, Double valor, String tipo, String descricao) {
        this.aluno = aluno;
        this.notaFiscal = notaFiscal;
        this.dataMovimentacao = dataMovimentacao;
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public LocalDate getDataMovimentacao() {
        return dataMovimentacao;
    }

    public void setDataMovimentacao(LocalDate dataMovimentacao) {
        this.dataMovimentacao = dataMovimentacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
