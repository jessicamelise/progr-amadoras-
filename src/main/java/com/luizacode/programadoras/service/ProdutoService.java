package com.luizacode.programadoras.service;

import javax.transaction.Transactional;

import com.luizacode.programadoras.dto.ProdutoDto;
import com.luizacode.programadoras.entidade.ProdutoEntidade;
import com.luizacode.programadoras.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoService() {
    }

    public ProdutoEntidade criarProduto(ProdutoDto produtoDto) {
        ProdutoEntidade produtoEntidade = new ProdutoEntidade(produtoDto.getValorDoProduto(),
                produtoDto.getNomeDoProduto());
        return produtoRepository.save(produtoEntidade);
    }

    public List<ProdutoEntidade> listarProdutos() {
        return produtoRepository.findAll();
    }
}
