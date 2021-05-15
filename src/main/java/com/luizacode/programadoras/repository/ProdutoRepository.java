package com.luizacode.programadoras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import  com.luizacode.programadoras.model.Produto;

@Repository 
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    Produto findByIdProduto(long id);

}