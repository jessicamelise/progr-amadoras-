package com.luizacode.programadoras.controller;
import  com.luizacode.programadoras.model.Cliente;
import com.luizacode.programadoras.repository.ClienteRepository;
import java.util.List;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Meotodo  get
    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    };
    
     // Meotodo  lista um unico produto por ID
     @GetMapping("/cliente/{id}")
     public Cliente listaClienteUnico(@PathVariable(value = "id") long id){
         return clienteRepository.findByIdCliente(id);
     };

    // Meotodo post 
    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED) // ao inves de retornar 200 vai retornar create quando inserir um cliente
    public Cliente adicionaCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

     //Meotodo delete
     @DeleteMapping("/cliente")
     public void deletaClienteId(@RequestBody Cliente cliente){
        clienteRepository.delete(cliente);
    }


}
