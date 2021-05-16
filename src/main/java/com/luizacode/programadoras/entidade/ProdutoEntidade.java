package com.luizacode.programadoras.entidade;

import javax.persistence.*;

@Entity
public class ProdutoEntidade extends EntidadeAbstrata {

    @Column(nullable = false)
    private double valorDoProduto;

    @Column(nullable = false)
    private String nomeDoProduto;

    public ProdutoEntidade(double valorDoProduto, String nomeDoProduto) {
        this.valorDoProduto = valorDoProduto;
        this.nomeDoProduto = nomeDoProduto;
    }

    protected ProdutoEntidade() {
    }

    public double getValorDoProduto() {
        return valorDoProduto;
    }

    public void setValorDoProduto(double valorDoProduto) {
        this.valorDoProduto = valorDoProduto;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

}
