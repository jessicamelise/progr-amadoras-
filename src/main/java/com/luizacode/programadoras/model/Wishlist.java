package com.luizacode.programadoras.model;

import java.util.List;

public class Wishlist {

    List<Produto> produtos;

    public Wishlist(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}
