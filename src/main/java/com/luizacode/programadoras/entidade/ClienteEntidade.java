package com.luizacode.programadoras.entidade;
import javax.persistence.*;

@Entity
public class ClienteEntidade extends EntidadeAbstrata {

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private String email;

    public ClienteEntidade(String nome,String endereco,String email) {
         this.nome = nome;
         this.endereco = endereco;
         this.email = email;
    }

    public ClienteEntidade(){}

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
