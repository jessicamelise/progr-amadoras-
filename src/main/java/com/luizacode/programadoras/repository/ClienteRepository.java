package com.luizacode.programadoras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  com.luizacode.programadoras.model.Cliente;

@Repository 
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
    Cliente findByIdCliente(long id);   

}
