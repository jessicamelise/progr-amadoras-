package com.luizacode.programadoras.controller;

import com.luizacode.programadoras.dto.ClienteDto;
import com.luizacode.programadoras.entidade.ClienteEntidade;
import com.luizacode.programadoras.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteService clienteServico;

    public ClienteController(ClienteService clienteServico) {
        this.clienteServico = clienteServico;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteEntidade adicionar(@RequestBody ClienteDto clienteDto) {
        return clienteServico.criarCliente(clienteDto);
    }




}
