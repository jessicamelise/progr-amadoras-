package com.luizacode.programadoras.models;

public class Produto {

    String detalheDoProduto;
    Long idProduto;

    public Produto(String detalheDoProduto, Long idProduto) {
        this.detalheDoProduto = detalheDoProduto;
        this.idProduto = idProduto;
    }

    public String getDetalheDoProduto() {
        return detalheDoProduto;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setDetalheDoProduto(String detalheDoProduto) {
        this.detalheDoProduto = detalheDoProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }


}
