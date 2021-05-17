package com.luizacode.programadoras.service;

import com.luizacode.programadoras.dto.ClienteProdutoDto;
// import java.util.Optional;
// import com.luizacode.programadoras.dto.*;
import com.luizacode.programadoras.entidade.*;
import com.luizacode.programadoras.repository.*;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
@Service
@Transactional
public class ListaDesejoService {

    @Autowired
    private ListaDesejoRepository listaDesejoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public ListaDesejoService() {}

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

    public ResponseEntity<ListaDesejoEntidade> adicionarItem(Long idCliente, ClienteProdutoDto clienteProduto) throws Exception {
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
                ListaDesejoEntidade adicionarItem = listaDesejoRepository.save(listaDesejoEntidade);

                URI location = ServletUriComponentsBuilder
                    .fromCurrentServletMapping()
                    .path("/clientes/"+ idCliente +"/listadesejo/{id}")
                    .build()
                    .expand(adicionarItem.getId())
                    .toUri();

                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(location);
                return new ResponseEntity<ListaDesejoEntidade>(headers, HttpStatus.CREATED);
            }
            
        }

    }


}