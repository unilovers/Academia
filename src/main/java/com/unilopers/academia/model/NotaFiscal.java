package com.unilopers.academia.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "notas_fiscais")
public class NotaFiscal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @Column(nullable = false)
    private LocalDate dataEmissao;

    @Column(nullable = false)
    private Double valorTotal;

    @OneToMany(mappedBy = "notaFiscal", cascade = CascadeType.ALL)
    private List<ItemMatricula> itens;

    public NotaFiscal() {}

    public NotaFiscal(Aluno aluno, LocalDate dataEmissao, Double valorTotal) {
        this.aluno = aluno;
        this.dataEmissao = dataEmissao;
        this.valorTotal = valorTotal;
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

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItemMatricula> getItens() {
        return itens;
    }

    public void setItens(List<ItemMatricula> itens) {
        this.itens = itens;
    }
}
