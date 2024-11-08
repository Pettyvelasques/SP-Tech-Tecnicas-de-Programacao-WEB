package school.sptech.calculadoraInss;

public class CalculadoraInss {

    public Double calcularInss(Double salario){
        Double salarioMinimo = 1412.00;
        if(salario < salarioMinimo){
            throw new IllegalArgumentException("Salário não pode ser menor que o salário mínimo");
        }

        Integer taxaInss = 20;

        if(salario <= 2000){
            taxaInss = 10;
        } else if (salario <= 3000) {
            taxaInss = 15;
        }

        Double valorPago = salario * taxaInss / 100;
        return valorPago;
    }
}
