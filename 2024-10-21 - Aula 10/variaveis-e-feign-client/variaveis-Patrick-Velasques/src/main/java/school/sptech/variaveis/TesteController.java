package school.sptech.variaveis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Value("${app.message}  ")
    private String mensagem;

    @GetMapping
    public ResponseEntity<String> texto(){
        return ResponseEntity.ok(mensagem);
    }
}
