package com.dev.igor.serviceproduto.service;

import com.dev.igor.serviceproduto.model.Produto;
import com.dev.igor.serviceproduto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto inserir(Produto produto) {
        return produtoRepository.save(produto);
    }
}
