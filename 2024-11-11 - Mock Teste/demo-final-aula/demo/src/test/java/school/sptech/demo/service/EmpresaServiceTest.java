package school.sptech.demo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import school.sptech.demo.entity.Empresa;
import school.sptech.demo.exception.ConflitoException;
import school.sptech.demo.exception.EntidadeNaoEncontradaException;
import school.sptech.demo.repository.EmpresaRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

// MockMvc - simula request
@ExtendWith(MockitoExtension.class)
class EmpresaServiceTest {

    // Alvo do teste
    @InjectMocks // 1 por classe de teste
    private EmpresaService service;

    // Dublê
    @Mock // pode ter vários....
    private EmpresaRepository repository;

    @Test
    @DisplayName("buscarTodos quando acionado deve retorna lista vazia")
    void buscarTodosQuandoAcionadoDeveRetornarListaVaziaTest() {

        // When (Quando, aqui ensinamos o dublê)
        // Isso não vai no banco de verdade.
        Mockito.when(repository.findAll())
                .thenReturn(Collections.emptyList());

        // Then (Act, onde provocamos a ação de fato);
        List<Empresa> resposta = service.buscarTodos();

        // Assert
        assertNotNull(resposta);
        assertTrue(resposta.isEmpty());
    }

    @Test
    @DisplayName("buscarTodos deve retornar lista com dois objetos do tipo Empresa")
    void deveRetornarEmpresasTest() {

        // Fixture (melhoria) = classes responsáveis por criar objetos mockados...
        // When - Arrange
        int quantidadeEsperada = 2;

        var arcosDOurados = Empresa.builder()
                .id(1)
                .nomeFantasia("McDonald's")
                .razaoSocial("Arcos DOurados")
                .cnpj("123456789")
                .dataFundacao(LocalDate.of(1955, 4, 15))
                .build();

        var atos = Empresa.builder()
                .id(1)
                .nomeFantasia("Atos")
                .razaoSocial("Atos serviços de TI")
                .cnpj("55555555555")
                .dataFundacao(LocalDate.of(1955, 4, 15))
                .build();

        Mockito.when(repository.findAll())
                .thenReturn(List.of(arcosDOurados, atos));

        // Then - Act
        List<Empresa> resposta = service.buscarTodos();

        // Assert
        assertNotNull(resposta);
        assertFalse(resposta.isEmpty());
        assertEquals(quantidadeEsperada, resposta.size());
    }

    // TDD = Test Driven Development
    // 1 Etapa: escreva um teste que falha;
    // 2 Etapa: Passar no teste
    // 3 Etapa: refatorar
    // buscarPorId(Integer id)
    @Test
    @DisplayName("buscarPorId deve lançar EntidadeNaoEncontradaException")
    void buscarDeveLancarEntidadeNaoEncontradaException() {

        //When - Arrange
        Mockito.when(repository.findById(Mockito.anyInt()))
                .thenReturn(Optional.empty());

        // Then - Act (Assert)
        EntidadeNaoEncontradaException excecao = assertThrows(
                EntidadeNaoEncontradaException.class,
                () -> service.buscarPorId(1)
        );

        assertEquals("Empresa não encontrada.", excecao.getMessage());
    }

    @Test
    @DisplayName("buscarPorId deve retornar empresa válida")
    void buscarPorIdDeveRetornarEmpresaValida() {
        var arcosDOurados = Empresa.builder()
                .id(1)
                .nomeFantasia("McDonald's")
                .razaoSocial("Arcos DOurados")
                .cnpj("123456789")
                .dataFundacao(LocalDate.of(1955, 4, 15))
                .build();

        // When
        Mockito.when(repository.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(arcosDOurados));

        // Then
        Empresa empresa = service.buscarPorId(1);

        assertNotNull(empresa);
        assertEquals(arcosDOurados.getId(), empresa.getId());
        assertEquals(arcosDOurados.getCnpj(), empresa.getCnpj());
        assertEquals(arcosDOurados.getNomeFantasia(), empresa.getNomeFantasia());
        assertEquals(arcosDOurados.getRazaoSocial(), empresa.getRazaoSocial());
        assertEquals(arcosDOurados.getDataFundacao(), empresa.getDataFundacao());

        // Serve para garantir que o mock foi acionado apenas uma unica vez...
        Mockito.verify(
                        repository,
                        Mockito.times(1))
                .findById(Mockito.anyInt()
                );
    }

    // Cadastro
    /*
        Cadastro de empresa:
            - não deve permitir cadastro de uma empresa com CNPJ duplicado

            1 - Já existe uma empresa com o CNPJ informado
            2 - Cadastro com sucesso, não existe empresa no banco com o CNPJ
    */

    @Test
    @DisplayName("Deve lancar ConflitoException quando o CNPJ existir")
    void deveLancarExcecaoQuandoCnpjForDuplicado() {

        // When
        var arcosDourados = Empresa.builder()
                .nomeFantasia("McDonald's")
                .razaoSocial("Arcos DOurados")
                .cnpj("123456789")
                .dataFundacao(LocalDate.of(1955, 4, 15))
                .build();

        Mockito.when(repository.existsByCnpjIgnoreCase(Mockito.anyString()))
                .thenReturn(true);

        // Then / Assert
        assertThrows(
                ConflitoException.class,
                () -> service.cadastrar(arcosDourados)
        );
    }

    @Test
    @DisplayName("Deve cadastrar com sucesso quando cnpj é único")
    void cadastraComSucessoTest() {
        // When
        var arcosDourados = Empresa.builder()
                .nomeFantasia("McDonald's")
                .razaoSocial("Arcos DOurados")
                .cnpj("123456789")
                .dataFundacao(LocalDate.of(1955, 4, 15))
                .build();

        var arcosDouradosResposta = Empresa.builder()
                .id(1)
                .nomeFantasia("McDonald's")
                .razaoSocial("Arcos DOurados")
                .cnpj("123456789")
                .dataFundacao(LocalDate.of(1955, 4, 15))
                .build();

        Mockito.when(repository.existsByCnpjIgnoreCase(Mockito.anyString()))
                .thenReturn(false);

        Mockito.when(repository.save(Mockito.any(Empresa.class)))
                .thenReturn(arcosDourados);

        // Then
        Empresa resposta = service.cadastrar(arcosDourados);

        assertNotNull(resposta);

        assertEquals(arcosDouradosResposta.getId(), resposta.getId());
        assertEquals(arcosDouradosResposta.getCnpj(), resposta.getCnpj());
        assertEquals(arcosDouradosResposta.getNomeFantasia(), resposta.getNomeFantasia());
        assertEquals(arcosDouradosResposta.getRazaoSocial(), resposta.getRazaoSocial());
        assertEquals(arcosDouradosResposta.getDataFundacao(), resposta.getDataFundacao());

        Mockito.verify(repository, Mockito.times(1))
                .existsByCnpjIgnoreCase(Mockito.anyString());

        Mockito.verify(repository, Mockito.times(1))
                .save(Mockito.any(Empresa.class));
    }
}