package com.dev.igor.serviceproduto.model;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "descricao", length = 100, nullable = false)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    public Produto() {
    }

    public Produto(@NonNull String descricao, @NonNull BigDecimal valor) {
        this.descricao = Objects.requireNonNull(descricao);
        this.valor = Objects.requireNonNull(valor);
    }

    public Long getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }
    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(getId(), produto.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
