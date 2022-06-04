package com.dev.igor.serviceproduto.http;

import com.dev.igor.serviceproduto.http.data.request.ProdutoPersistDto;
import com.dev.igor.serviceproduto.http.data.response.ProdutoResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public interface ProdutoController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProdutoResponseDto inserir(@Valid @RequestBody ProdutoPersistDto dto);

    @Operation(summary = "Retorna produto correspondente ao identificador recuperado por parâmetro")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "404",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            examples = @ExampleObject(
                                    value = "{ \"codigo\": \"X_100\", \"mensagem\": \"Produto de código 45 não encontrado\", \"documentacao\": null }"
                            )
                    )
            )
    })
    @GetMapping("/{id}")
    ProdutoResponseDto one(@PathVariable("id") Long id);
}
