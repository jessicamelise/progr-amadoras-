package com.luizacode.programadoras.service;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import com.luizacode.programadoras.MocksApplication;
import com.luizacode.programadoras.dto.ClienteDto;
import com.luizacode.programadoras.entidade.ClienteEntidade;
import com.luizacode.programadoras.repository.ClienteRepository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MocksApplication.class)
public class ClienteServiceUnitTest {

    @Test
    public void listarClientes_BuscarListaClientes_SemFiltro() {
        // Arrange
        List<ClienteEntidade> valorEsperado = new ArrayList<ClienteEntidade>();
        valorEsperado.add(new ClienteEntidade("Teste", "Rua teste n 12", "teste@teste.com"));
        valorEsperado.add(new ClienteEntidade("TesteDois", "Rua teste n 12", "testedois@teste.com"));

        ClienteRepository mockrepository = Mockito.mock(ClienteRepository.class);
        Mockito.when(mockrepository.findAll()).thenReturn(valorEsperado);

        // Act
        ClienteService service = new ClienteService(mockrepository);
        List<ClienteEntidade> resultado = service.listarClientes();

        // Assert
        Assert.assertEquals(valorEsperado.size(), resultado.size());
        Assert.assertEquals(valorEsperado.get(0).getNome(), resultado.get(0).getNome());
        Assert.assertEquals(valorEsperado.get(1).getNome(), resultado.get(1).getNome());
    }

    @Test
    public void criarCliente_InserindoNovoCliente() {
        // Arrange
        ClienteEntidade valorEsperado = new ClienteEntidade("Teste", "Rua teste n 12", "teste@teste.com");
        ClienteDto valorClienteInserido = new ClienteDto();
        valorClienteInserido.setNome("Teste");
        valorClienteInserido.setEndereco("Rua teste n 12");
        valorClienteInserido.setEmail("teste@teste.com");

        ClienteRepository mockrepository = Mockito.mock(ClienteRepository.class);
        Mockito.when(mockrepository.save(any())).thenReturn(valorEsperado);

        // Act
        ClienteService service = new ClienteService(mockrepository);
        ClienteEntidade resultado = service.criarCliente(valorClienteInserido);

        // Assert
        Assert.assertEquals(valorEsperado.getNome(), resultado.getNome());
    }

}
