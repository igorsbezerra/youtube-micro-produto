package com.dev.igor.serviceproduto.http.data.response;

import org.springframework.lang.NonNull;

import java.util.Objects;

public class Error {

    private final String codigo;
    private final String mensagem;
    private String documentacao;

    public Error(@NonNull String codigo, @NonNull String mensagem) {
        this.codigo = Objects.requireNonNull(codigo);
        this.mensagem = Objects.requireNonNull(mensagem);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDocumentacao() {
        return documentacao;
    }
}
