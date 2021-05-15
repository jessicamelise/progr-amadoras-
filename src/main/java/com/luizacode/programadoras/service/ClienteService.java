package com.luizacode.programadoras.service;
import javax.transaction.Transactional;

import com.luizacode.programadoras.dto.ClienteDto;
import com.luizacode.programadoras.entidade.ClienteEntidade;
import com.luizacode.programadoras.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService() {}

    public ClienteEntidade criarCliente(ClienteDto clienteDto) {
        ClienteEntidade clienteEntidade = new ClienteEntidade(clienteDto.getNome(), clienteDto.getEndereco(), clienteDto.getEmail());
        return clienteRepository.save(clienteEntidade);
    }

}
