package com.luizacode.programadoras.service;
import javax.transaction.Transactional;

import com.luizacode.programadoras.dto.ClienteDto;
import com.luizacode.programadoras.entidade.ClienteEntidade;
import com.luizacode.programadoras.repository.ClienteRepository;
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
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService() {}

    public ResponseEntity<ClienteEntidade> criarCliente(ClienteDto clienteDto) {
        ClienteEntidade clienteEntidade = new ClienteEntidade(clienteDto.getNome(), clienteDto.getEndereco(), clienteDto.getEmail());
        ClienteEntidade criarCliente = clienteRepository.save(clienteEntidade);

        URI location = ServletUriComponentsBuilder
            .fromCurrentServletMapping()
            .path("/clientes/{id}")
            .build()
            .expand(criarCliente.getId())
            .toUri();

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        return new ResponseEntity<ClienteEntidade>(headers, HttpStatus.CREATED);
    }

    public List<ClienteEntidade> listarClientes() {
        return clienteRepository.findAll();
    }
}
