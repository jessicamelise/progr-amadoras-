package com.luizacode.programadoras.models;

import java.util.List;

public class Wishlist {

    List<Produto> produtos;

    public Wishlist(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produto produto) {

        if (!produtos.contains(produto)) {
            produtos.add(produto);
        } else {
            System.out.println("O Produto X já está na base");
        }

    }

    public void removerProduto(Produto produto) {

        if (produtos.contains(produto)) {
            produtos.remove(produto);
        } else {
            System.out.println("O Produto X não está na base");
        }
    }

}
