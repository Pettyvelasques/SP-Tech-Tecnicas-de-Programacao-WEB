package school.sptech.variaveis.musica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaIntegration integration;

    @GetMapping
    public ResponseEntity<List<Musica>> listar() {
        List<Musica> musicas = integration.buscarTodos();
        return ResponseEntity.status(200).body(musicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> buscarPorId(@PathVariable int id){
        Musica musica = integration.buscarPorId(id);
        return ResponseEntity.ok(musica);
    }

}
