package com.dev.igor.serviceproduto.http;

import com.dev.igor.serviceproduto.http.data.request.ProdutoPersistDto;
import com.dev.igor.serviceproduto.http.data.response.ProdutoResponseDto;
import com.dev.igor.serviceproduto.model.Produto;
import com.dev.igor.serviceproduto.service.ProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ProdutoResponseDto inserir(@RequestBody ProdutoPersistDto dto) {
        Produto produto = new Produto(dto.getDescricao(), dto.getValor());
        Produto produtoPersistido =  produtoService.inserir(produto);
        return new ProdutoResponseDto(produtoPersistido.getId(), produtoPersistido.getDescricao());
    }
}
