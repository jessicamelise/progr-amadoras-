package com.luizacode.programadoras.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class ProdutoDto {

    @NotNull
    @DecimalMin(value = "0.01")
    private double valorDoProduto;

    @NotNull
    private String nomeDoProduto;

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
