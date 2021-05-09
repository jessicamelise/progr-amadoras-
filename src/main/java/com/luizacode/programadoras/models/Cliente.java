package com.luizacode.programadoras.models;

public class Cliente {

  String nome, endereco, email;
  Long idCliente;

  public Cliente(String nome, String endereco, String email, Long idCliente) {
    this.nome = nome;
    this.endereco = endereco;
    this.email = email;
    this.idCliente = idCliente;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Long idCliente) {
    this.idCliente = idCliente;
  }

}