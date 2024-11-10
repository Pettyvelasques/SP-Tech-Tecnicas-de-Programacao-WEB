package school.sptech.calculadoraInss;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraInssTest {

    @Test
    @DisplayName("Calcular INSS quando salário for menor que o salário mínimo deve lançar exceção")
    void calcularInssSalarioMenorSalarioMinimo() {
        CalculadoraInss calculadora = new CalculadoraInss();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcularInss(1100.00)
        );
        IllegalArgumentException exception2 = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcularInss(1400.00)
        );
        IllegalArgumentException exception3 = assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcularInss(800.00)
        );

        assertEquals("Salário não pode ser menor que o salário mínimo", exception.getMessage());
        assertEquals("Salário não pode ser menor que o salário mínimo", exception2.getMessage());
        assertEquals("Salário não pode ser menor que o salário mínimo", exception3.getMessage());
    }

    @Test
    @DisplayName("Calcular INSS quando salário menor ou igual a 2.000 deve utilizar taxa base de 10%")
    void calcularInssSalarioMenor2000(){
        CalculadoraInss calculadora = new CalculadoraInss();
        double resultadoEsperado = 180.00;
        double resultadoEsperado2 = 150.00;
        double resultadoEsperado3 = 200.00;

        double resposta = calculadora.calcularInss(1800.00);
        double resposta2 = calculadora.calcularInss(1500.00);
        double resposta3 = calculadora.calcularInss(2000.00);

        assertEquals(resultadoEsperado, resposta);
        assertEquals(resultadoEsperado2, resposta2);
        assertEquals(resultadoEsperado3, resposta3);
    }

    @Test
    @DisplayName("Calcular INSS quando salário maior que 2.000 e menor ou igual a 3.000 deve utilizar taxa base de 15%")
    void calcularInssSalarioEntre2000e3000(){
        CalculadoraInss calculadora = new CalculadoraInss();
        double resultadoEsperado = 315.00;
        double resultadoEsperado2 = 375.00;
        double resultadoEsperado3 = 450.00;

        double resposta = calculadora.calcularInss(2100.00);
        double resposta2 = calculadora.calcularInss(2500.00);
        double resposta3 = calculadora.calcularInss(3000.00);

        assertEquals(resultadoEsperado, resposta);
        assertEquals(resultadoEsperado2, resposta2);
        assertEquals(resultadoEsperado3, resposta3);
    }

    @Test
    @DisplayName("Calcular INSS quando salário maior que 3.000 deve utilizar taxa base de 20%")
    void calcularInssSalarioMaiorQue3000(){
        CalculadoraInss calculadora = new CalculadoraInss();
        double resultadoEsperado = 620.00;
        double resultadoEsperado2 = 700.00;
        double resultadoEsperado3 = 1000.00;

        double resposta = calculadora.calcularInss(3100.00);
        double resposta2 = calculadora.calcularInss(3500.00);
        double resposta3 = calculadora.calcularInss(5000.00);

        assertEquals(resultadoEsperado, resposta);
        assertEquals(resultadoEsperado2, resposta2);
        assertEquals(resultadoEsperado3, resposta3);
    }
}