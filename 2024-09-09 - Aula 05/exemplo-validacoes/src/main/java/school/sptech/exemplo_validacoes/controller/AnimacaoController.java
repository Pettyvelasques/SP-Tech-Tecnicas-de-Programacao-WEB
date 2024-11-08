package school.sptech.exemplo_validacoes.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.exemplo_validacoes.repository.AnimacaoRepository;
import school.sptech.exemplo_validacoes.entity.Animacao;
import school.sptech.exemplo_validacoes.service.AnimacaoService;

import java.util.List;

@RestController
@RequestMapping("/animacoes")
public class AnimacaoController {

    @Autowired
    private AnimacaoService service;

    @GetMapping
    public ResponseEntity<List<Animacao>> listar() {
        List<Animacao> animacoes = service.listar();

        if(animacoes.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(animacoes);
    }

    @PostMapping
    public ResponseEntity<Animacao> cadastrar(@RequestBody @Valid Animacao animacao){

//        Validação sem Validator

//        if(Objects.nonNull(animacao.getNome()) && animacao.getNome().length() < 2){
//            return ResponseEntity.status(400).build();
//        }

//        if(Objects.nonNull(animacao.getQuantidadeEpisodios()) && animacao.getQuantidadeEpisodios() < 0){
//            return ResponseEntity.status(400).build();
//        }

        Animacao animacaoSalva = this.service.cadastrar(animacao);

        return ResponseEntity.status(201).body(animacaoSalva);
    }

    @GetMapping("/{id")
    public ResponseEntity<Animacao> buscarPorId(@PathVariable int id){
        Animacao animacao = service.buscarPorId(id);

        return ResponseEntity.status(200).body(animacao);
    }
}
