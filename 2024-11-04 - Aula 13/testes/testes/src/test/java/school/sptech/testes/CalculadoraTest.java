package school.sptech.testes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*; // em testes

class CalculadoraTest {

    /*
        Podem ocorrer tres cenarios:
            - Sucesso; Check verde
            - Falha; ! amarela
            - ERRO; X vermelho
    */

    @Test
    @DisplayName("Somar quando acionado com valores 2 e 2 deve retornar 4")
    void somarQuandoAcionadoComNumerosValidosDeveRetornarCorretamente() {

        // Arrange - Arranjo - configuração - setup
        Calculadora calculadora = new Calculadora();
        int resultadoEsperado = 4;

        // ACT - ato - ação - invocando metodos
        Integer resposta = calculadora.somar(2, 2);

        // ASSERT -> ASSERÇÃO
        assertEquals(resultadoEsperado, resposta);
    }

    @Test
    @DisplayName("Somar quando acionado com valores 40 e 2 deve retornar 42")
    void somarQuandoAcionadoComNumerosValidosDeveRetornarCorretamente2() {
        Calculadora calculadora = new Calculadora();

        int resultadoEsperado = 42;

        // ACT - ato - ação - invocando metodos
        Integer resposta = calculadora.somar(40, 2);

        // ASSERT -> ASSERÇÃO
        assertEquals(resultadoEsperado, resposta);
    }

    @Test
    @DisplayName("Somar quando acionado com o valor nulo (null) deve lancar excecao")
    void somarQuandoAcionadoComValorNuloDeveLancarExcecao() {

        // ARRANGE
        Calculadora calculadora = new Calculadora();

        // ACT & ASSERT
        IllegalArgumentException illegalArgumentException = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.somar(null, 3)
        );

        String mensagem = illegalArgumentException.getMessage();

        assertEquals("não permitido nulo", mensagem);
    }

    @Test
    @DisplayName("Somar quando acionado com valores não deve retornar nulo")
    void nuloTest() {

        Calculadora calculadora = new Calculadora();

        int resultadoEsperado = 10;

        Integer resposta = calculadora.somar(5, 5);

        assertNotNull(resposta);
        assertEquals(resultadoEsperado, resposta);
    }

    @Test
    @DisplayName("Dividir quando acionado com os valor 10 e 2 deve retornar 5")
    void dividirTest() {
        Calculadora calculadora = new Calculadora();

        double resultadoEsperado = 5.0;

        double resposta = calculadora.dividir(10.0, 2.0);

        assertEquals(resultadoEsperado, resposta, 1); // delta representa margem de erro.
    }
}