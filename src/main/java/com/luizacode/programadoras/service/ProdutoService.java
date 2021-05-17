package com.luizacode.programadoras.service;

import javax.transaction.Transactional;

import com.luizacode.programadoras.dto.ProdutoDto;
import com.luizacode.programadoras.entidade.ProdutoEntidade;
import com.luizacode.programadoras.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.List;

@Service
@Transactional
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoService() {
    }

    public ResponseEntity<ProdutoEntidade> criarProduto(ProdutoDto produtoDto) {
        ProdutoEntidade produtoEntidade = new ProdutoEntidade(produtoDto.getValorDoProduto(),
            produtoDto.getNomeDoProduto());
        ProdutoEntidade criarProduto = produtoRepository.save(produtoEntidade);

        URI location = ServletUriComponentsBuilder
            .fromCurrentServletMapping()
            .path("/produtos/{id}")
            .build()
            .expand(criarProduto.getId())
            .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        return new ResponseEntity<ProdutoEntidade>(headers, HttpStatus.CREATED);
    }

    public List<ProdutoEntidade> listarProdutos() {
        return produtoRepository.findAll();
    }
}
