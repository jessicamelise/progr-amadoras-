package com.luizacode.programadoras.models;

import java.util.List;

public class Wishlist {

    List<Produto> produtos;
    Long idCliente;

    public Wishlist(List<Produto> produtos, Long idCliente) {
        this.produtos = produtos;
        this.idCliente = idCliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Produto> get_wishlist_by_id(Long idCliente) {
        if (idCliente == this.idCliente) {
            List<Produto> prod = this.getProdutos();

            for(int i=0; i< prod.size();i++) {
                System.out.println(prod.get(i).getDetalheDoProduto());
            }
            return this.getProdutos();
        } else {
            System.out.println("Wishlist nao existe!");
            return null;
        }
    }
}
