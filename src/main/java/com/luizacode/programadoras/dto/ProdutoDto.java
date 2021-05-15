package com.luizacode.programadoras.dto;
import javax.validation.constraints.NotNull;

public class ProdutoDto {

    @NotNull
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
