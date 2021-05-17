package com.luizacode.programadoras.controller;

import com.luizacode.programadoras.dto.ProdutoDto;
import com.luizacode.programadoras.entidade.ProdutoEntidade;
import com.luizacode.programadoras.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return produtoServico.criarProduto(produto);
    }

    @GetMapping
    public List<ProdutoEntidade> listar() {
        return produtoServico.listarProdutos();
    }

}
