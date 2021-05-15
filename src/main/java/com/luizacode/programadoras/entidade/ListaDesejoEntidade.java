package com.luizacode.programadoras.entidade;

import javax.persistence.*;

@Entity
public class ListaDesejoEntidade extends EntidadeAbstrata {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "clienteId")
    ClienteEntidade cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "produtoId")
    ProdutoEntidade produto;

    public ListaDesejoEntidade(ClienteEntidade cliente, ProdutoEntidade produto) {
        this.cliente = cliente;
        this.produto = produto;
    }

    protected ListaDesejoEntidade() {}


    public ClienteEntidade getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntidade cliente) {
        this.cliente = cliente;
    }

    public ProdutoEntidade getProduto() {
        return produto;
    }
    public void setProduto(ProdutoEntidade produto) {
        this.produto = produto;
    }
}
