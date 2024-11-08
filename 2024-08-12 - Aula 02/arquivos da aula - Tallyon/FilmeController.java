package school.sptech.aula02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @GetMapping("/favorito")
    public List<Filme> getFavorito(){
        Diretor brian = new Diretor("Brain");
        Diretor gisvaldo = new Diretor("Gisvaldo");
        Filme filmeFavorito1 = new Filme(
                "Meu malvado favorito",
                brian
        );

        Filme filmeFavorito2 = new Filme(
               "Titanic",
                gisvaldo
        );
        List<Filme> filmes = List.of(filmeFavorito1, filmeFavorito2);
        return filmes;
    }
}
