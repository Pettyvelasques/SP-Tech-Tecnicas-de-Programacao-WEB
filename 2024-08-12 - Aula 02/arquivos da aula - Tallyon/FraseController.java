package school.sptech.aula02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Metaprogramação != Cosmetico interface no código
@RestController // Cria uma controladora REST
@RequestMapping("/frases") //Faz com que todos as URI comecem com "/frases"
public class FraseController {

    /*
    Controladora é responsável por um recurso lida diretamente com Req. e Resp.
    NEM TUDO numa controller é endpoint

    Recurso = Objeto sistemetico, estratégico para operação

    endpoint (rota) = canal de comunicação com a Web para um determinado recurso

    */


    /*
    Essa notação posssibiliya que esse metodo se torne um endpoint do tipo GET*/
    @GetMapping // URI
    public String helloSpring(){
        return "Olá Mundo!";
    }

    /* Existe diversas maneiras de enviar params para uma API REST
    Maneira consiste nessse tipo
    localhost:8080/frasses/saudacao/Talluon -> param
     */
    @GetMapping("saudacao/{nome}/{idade}") // URI
    public String saudacao(
            @PathVariable String nome,
            @PathVariable Integer idade
    ){
        return "Olá %s, sua idade é %d" .formatted(nome, idade);
    }

    @GetMapping("numero/{numero}") // URI
    public String numero(
            @PathVariable Integer numero
    ){
        return "Seu numero da sorte é %d ".formatted(numero);
    }

}
