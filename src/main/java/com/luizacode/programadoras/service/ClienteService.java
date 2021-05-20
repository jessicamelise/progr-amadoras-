package com.luizacode.programadoras.service;
import javax.transaction.Transactional;

import com.luizacode.programadoras.dto.ClienteDto;
import com.luizacode.programadoras.entidade.ClienteEntidade;
import com.luizacode.programadoras.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteEntidade criarCliente(ClienteDto clienteDto) {
        ClienteEntidade clienteEntidade = new ClienteEntidade(clienteDto.getNome(), clienteDto.getEndereco(), clienteDto.getEmail());
        return clienteRepository.save(clienteEntidade);
    }

    public List<ClienteEntidade> listarClientes() {
        return clienteRepository.findAll();
    }
}
