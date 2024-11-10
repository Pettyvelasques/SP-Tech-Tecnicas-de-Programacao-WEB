package school.sptech.testes;

public class Calculadora {

    // != TDD
    public Integer somar(Integer num1, Integer num2){

        if (num1 == null || num2 == null){
            throw new IllegalArgumentException("não permitido nulo");
        }

        return num1 + num2;
    }

    public Double dividir(double numero1, double numero2) {
        return numero1 / numero2;
    }
}
