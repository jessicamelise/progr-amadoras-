package com.luizacode.programadoras.controller;

import com.luizacode.programadoras.dto.ProdutoDto;
import com.luizacode.programadoras.entidade.ProdutoEntidade;
import com.luizacode.programadoras.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private ProdutoService produtoServico;

    public ProdutoController(ProdutoService produtoServico) {
        this.produtoServico = produtoServico;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntidade adicionar(@RequestBody ProdutoDto produto) {
        return produtoServico.criarProduto(produto);
    }

    @GetMapping
    public List<ProdutoEntidade> listar() {
        return produtoServico.listarProdutos();
    }

}
