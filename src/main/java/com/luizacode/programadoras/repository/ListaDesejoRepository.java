package com.luizacode.programadoras.repository;
import com.luizacode.programadoras.entidade.ListaDesejoEntidade;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

@Repository
public interface ListaDesejoRepository extends JpaRepository<ListaDesejoEntidade, Long>, QuerydslPredicateExecutor<ListaDesejoEntidade> {
}
