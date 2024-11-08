package school.sptech.variaveis.musica;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "musica-integration", url = "${integration.music}")
public interface MusicaIntegration {

    @GetMapping
    List<Musica> buscarTodos();

    @GetMapping("/{id}")
    Musica buscarPorId(@PathVariable int id);
}
