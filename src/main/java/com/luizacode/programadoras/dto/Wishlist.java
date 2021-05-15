package com.luizacode.programadoras.dto;

import java.util.List;

public class Wishlist {

    List<ProdutoDto> produtos;

    public Wishlist(List<ProdutoDto> produtos) {
        this.produtos = produtos;
    }

    public List<ProdutoDto> getProdutos() {
        return produtos;
    }
}
