package com.luizacode.programadoras.controller;

import com.luizacode.programadoras.dto.ClienteDto;
import com.luizacode.programadoras.entidade.ClienteEntidade;
import com.luizacode.programadoras.entidade.ListaDesejoEntidade;
import com.luizacode.programadoras.service.ClienteService;
import com.luizacode.programadoras.service.ListaDesejoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ListaDesejoService listaDesejoService;
    private ClienteService clienteServico;

    public ClienteController(ClienteService clienteServico, ListaDesejoService listaDesejoService) {
        this.clienteServico = clienteServico;
        this.listaDesejoService = listaDesejoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteEntidade adicionar(@RequestBody ClienteDto cliente) {
        return clienteServico.criarCliente(cliente);
    }

    @GetMapping
    public List<ClienteEntidade> listar() {
        return clienteServico.listarClientes();
    }

    @GetMapping("/{idCliente}/listadesejo")
    public List<ListaDesejoEntidade> pegarListaDesejo(@PathVariable Long idCliente) {
        return (List<ListaDesejoEntidade>) listaDesejoService.procurar(idCliente);
    }

    @GetMapping("/{idCliente}/listadesejo/{idProduto}")
    public String verificarItemExistente(@PathVariable Long idCliente, @PathVariable Long idProduto) {
        return listaDesejoService.verificarSeExiste(idCliente, idProduto);
    }

}
