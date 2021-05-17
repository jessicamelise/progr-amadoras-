package com.luizacode.programadoras.dto;

import javax.validation.constraints.NotNull;

public class ClienteProdutoDto {

    @NotNull
    private Long produtoId;

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }
}
