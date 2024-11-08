package school.sptech.aula02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    @Componet - componente do String
    @Service - É um serviço especializado
    @Repository - Componente de persistencia
    @Controller - Controla (MVC, html)
    @RestController - Controladorea REST
    @Configuration - Componente que configura algo

    É instaciado somente uma unica vez no starttuo/inicio da aplicação

    Padrões de projeto = Singleton
 */

@RequestMapping("/calculos/")
@RestController
public class CalculadoraController {

    private Integer contador = 0;
    @GetMapping("contador")
    public Integer contar(){
        return ++this.contador;
    }

    @GetMapping("somar/{n1}/{n2}")
    public Integer somar(
            @PathVariable Integer n1,
            @PathVariable Integer n2
    ){
        return n1+n2;
    }
    @GetMapping("somar/{n1}/{n2}/{n3}")
    public Integer somar(
            @PathVariable Integer n1,
            @PathVariable Integer n2,
            @PathVariable Integer n3
    ){
        return n1+n2+n3;
    }

}
