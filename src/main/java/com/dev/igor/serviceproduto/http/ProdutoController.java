package com.dev.igor.serviceproduto.http;

import com.dev.igor.serviceproduto.http.data.request.ProdutoPersistDto;
import com.dev.igor.serviceproduto.http.data.response.ProdutoResponseDto;
import com.dev.igor.serviceproduto.model.Produto;
import com.dev.igor.serviceproduto.service.ProdutoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ModelMapper modelMapper;

    public ProdutoController(ProdutoService produtoService, ModelMapper modelMapper) {
        this.produtoService = produtoService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponseDto inserir(@Valid @RequestBody ProdutoPersistDto dto) {
        Produto produto = new Produto(dto.getDescricao(), dto.getValor());
        Produto produtoPersistido =  produtoService.inserir(produto);
        return modelMapper.map(produtoPersistido, ProdutoResponseDto.class);
    }

    @GetMapping("/{id}")
    public ProdutoResponseDto one(@PathVariable("id") Long id) {
        var produto = produtoService.one(id);
        return modelMapper.map(produto, ProdutoResponseDto.class);
    }

}
