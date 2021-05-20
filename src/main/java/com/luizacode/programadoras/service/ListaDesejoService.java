package com.luizacode.programadoras.service;

import com.luizacode.programadoras.dto.ClienteProdutoDto;

import com.luizacode.programadoras.entidade.*;
import com.luizacode.programadoras.repository.*;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Service;

import java.util.Optional;

import javax.transaction.Transactional;
@Service
@Transactional
public class ListaDesejoService {

    private ListaDesejoRepository listaDesejoRepository;
    
    private ClienteRepository clienteRepository;

    private ProdutoRepository produtoRepository;

    public ListaDesejoService(ListaDesejoRepository listaDesejoRepository,
        ClienteRepository clienteRepository,
        ProdutoRepository produtoRepository) {
            this.listaDesejoRepository = listaDesejoRepository;
            this.clienteRepository = clienteRepository;
            this.produtoRepository = produtoRepository;
        }

    public Iterable<ListaDesejoEntidade> procurar(Long id) {
        QListaDesejoEntidade qlista = QListaDesejoEntidade.listaDesejoEntidade;
        BooleanExpression encontrarCliente = qlista.cliente.id.eq(id);
        Iterable<ListaDesejoEntidade> listaFiltrada = listaDesejoRepository.findAll(encontrarCliente);
        return listaFiltrada;
    }

    public String verificarSeExiste(Long id, Long produtoId) {
        QListaDesejoEntidade qlista = QListaDesejoEntidade.listaDesejoEntidade;
        BooleanExpression encontrarCliente = qlista.cliente.id.eq(id);
        BooleanExpression encontrarProduto = qlista.produto.id.eq(produtoId);
        boolean existeProduto = listaDesejoRepository.exists(encontrarCliente.and(encontrarProduto));
        if (existeProduto) {
            return "Produto já está na lista de desejo";
        } else {
            return "Produto não está na lista de desejo";
        }
    }

    public void deletar(Long clienteId, Long produtoId) {
        QListaDesejoEntidade qlista = QListaDesejoEntidade.listaDesejoEntidade;
        BooleanExpression encontrarCliente = qlista.cliente.id.eq(clienteId);
        BooleanExpression encontrarProduto = qlista.produto.id.eq(produtoId);
        Iterable<ListaDesejoEntidade> listaFiltrada = listaDesejoRepository.findAll(encontrarCliente.and(encontrarProduto));
        listaDesejoRepository.deleteAll(listaFiltrada);
    }

    public ListaDesejoEntidade adicionarItem(Long idCliente, ClienteProdutoDto clienteProduto) throws Exception {
        Optional<ClienteEntidade> adicionarCliente;
        Optional<ProdutoEntidade> adicionarProduto;
        String produtoExiste;

        adicionarCliente = clienteRepository.findById(idCliente);
        adicionarProduto = produtoRepository.findById(clienteProduto.getProdutoId());

        QListaDesejoEntidade qlista = QListaDesejoEntidade.listaDesejoEntidade;
        BooleanExpression encontrarCliente = qlista.cliente.id.eq(idCliente);
        Long listaFiltrada = listaDesejoRepository.count(encontrarCliente);

        if (listaFiltrada >= 20) {
            throw new Exception("Atingiu o limite");
        } else {
            produtoExiste = verificarSeExiste(idCliente, clienteProduto.getProdutoId());
            if (produtoExiste.equals("Produto já está na lista de desejo")) {
                throw new Exception("Produto já está na lista");
            } else {
                ListaDesejoEntidade listaDesejoEntidade = new ListaDesejoEntidade(adicionarCliente.get(), adicionarProduto.get());
                return listaDesejoRepository.save(listaDesejoEntidade);
            }
            
        }

    }


}