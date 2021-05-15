package com.luizacode.programadoras.repository;
import com.luizacode.programadoras.entidade.ClienteEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntidade, Long>, QuerydslPredicateExecutor<ClienteEntidade> {

}

