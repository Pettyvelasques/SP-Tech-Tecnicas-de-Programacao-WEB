package school.sptech.calculadoraInss;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraInssTest {

    @Test
    @DisplayName("Calcular INSS quando salário for menor que o salário mínimo deve lançar exceção")
    void calcularInss() {
        CalculadoraInss calculadora = new CalculadoraInss();
        assertThrows(
                IllegalArgumentException.class,
                () -> calculadora.calcularInss(1200.00),
                "Salário não pode ser menor que o salário mínimo"
        );
    }

    @Test
    @DisplayName("Calcular INSS quando salário menor que 2.000 deve utilizar taxa base de 10%")
    void calcular
}