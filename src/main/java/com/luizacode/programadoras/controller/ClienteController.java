package com.luizacode.programadoras.controller;

import com.luizacode.programadoras.dto.ClienteDto;
import com.luizacode.programadoras.dto.ClienteProdutoDto;
import com.luizacode.programadoras.entidade.ClienteEntidade;
import com.luizacode.programadoras.entidade.ListaDesejoEntidade;
import com.luizacode.programadoras.service.ClienteService;
import com.luizacode.programadoras.service.ListaDesejoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

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
    public ResponseEntity<ClienteEntidade> adicionar(@RequestBody @Valid ClienteDto cliente) {
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

    @DeleteMapping("/{idCliente}/listadesejo/{idProduto}")
    public String deletarItemListaDesejo(@PathVariable Long idCliente, @PathVariable Long idProduto ) {
        listaDesejoService.deletar(idCliente, idProduto);
        return "Produto Deletado";
    }

    @PostMapping("/{idCliente}/listadesejo")
    public ResponseEntity<ListaDesejoEntidade> adicionarListaDesejo(@PathVariable Long idCliente, @RequestBody @Valid ClienteProdutoDto clienteProduto) throws Exception {
        return listaDesejoService.adicionarItem(idCliente, clienteProduto);
    }
}
