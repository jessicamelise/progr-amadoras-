package com.luizacode.programadoras.service;

import javax.transaction.Transactional;

import com.luizacode.programadoras.dto.ProdutoDto;
import com.luizacode.programadoras.entidade.ProdutoEntidade;
import com.luizacode.programadoras.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
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
