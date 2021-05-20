package com.luizacode.programadoras.controller;

import com.luizacode.programadoras.dto.ProdutoDto;
import com.luizacode.programadoras.entidade.ProdutoEntidade;
import com.luizacode.programadoras.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import java.net.URI;


import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private ProdutoService produtoServico;

    public ProdutoController(ProdutoService produtoServico) {
        this.produtoServico = produtoServico;
    }

    @PostMapping
    public ResponseEntity<ProdutoEntidade> adicionar(@RequestBody @Valid ProdutoDto produto) {
        ProdutoEntidade criar = produtoServico.criarProduto(produto);
        URI location = ServletUriComponentsBuilder
            .fromCurrentServletMapping()
            .path("/produtos/{id}")
            .build()
            .expand(criar.getId())
            .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        return new ResponseEntity<ProdutoEntidade>(headers, HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProdutoEntidade> listar() {
        return produtoServico.listarProdutos();
    }

}
