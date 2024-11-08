package school.sptech.variaveis.cep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoIntegration cepIntegration;

    @GetMapping("/{cep}")
    public ResponseEntity<Endereco> buscarPorCep(@PathVariable String cep){
        Endereco cepEncontrado = cepIntegration.buscarPorCep(cep);
        return ResponseEntity.ok(cepEncontrado);
    }
}
