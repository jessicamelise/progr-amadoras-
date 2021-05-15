package com.luizacode.programadoras.service;
import com.luizacode.programadoras.entidade.ListaDesejoEntidade;
import com.luizacode.programadoras.repository.ListaDesejoRepository;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
}
