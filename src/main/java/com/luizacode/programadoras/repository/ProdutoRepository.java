package com.luizacode.programadoras.repository;

import com.luizacode.programadoras.entidade.ProdutoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntidade, Long>, QuerydslPredicateExecutor<ProdutoEntidade> {

}
