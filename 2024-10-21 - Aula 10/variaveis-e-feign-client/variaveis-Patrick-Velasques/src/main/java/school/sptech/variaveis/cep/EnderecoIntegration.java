package school.sptech.variaveis.cep;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "cep-integration", url = "https://viacep.com.br/ws")
public interface EnderecoIntegration {

    //Toda request com response.status != de 2xx
    //Feign entende como exception
    @GetMapping("/{cep}/json")
    Endereco buscarPorCep(@PathVariable String cep);
}
