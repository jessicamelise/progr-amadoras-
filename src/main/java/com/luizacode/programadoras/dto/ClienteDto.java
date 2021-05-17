package com.luizacode.programadoras.dto;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class ClienteDto {
  @NotNull
  private String nome;
  
  @NotNull
  private String endereco;

  @NotNull
  @Email
  private String email;

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

 }