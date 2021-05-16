package com.luizacode.programadoras.service;

// import java.util.Optional;
// import com.luizacode.programadoras.dto.*;
import com.luizacode.programadoras.entidade.*;
import com.luizacode.programadoras.repository.*;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
@Service
@Transactional
public class ListaDesejoService {

    @Autowired
    private ListaDesejoRepository listaDesejoRepository;

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
 
}