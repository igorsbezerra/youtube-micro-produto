package com.dev.igor.serviceproduto.http.data.response;

public class ProdutoResponseDto {

    private Long id;
    private String descricao;


    public ProdutoResponseDto() {
    }

    public ProdutoResponseDto(Long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }
}
