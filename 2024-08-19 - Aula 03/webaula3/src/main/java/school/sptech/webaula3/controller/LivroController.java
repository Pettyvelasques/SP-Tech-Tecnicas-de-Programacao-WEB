package school.sptech.webaula3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.webaula3.entity.Livro;
import school.sptech.webaula3.repository.LivroRepository;

import java.util.List;
import java.util.Optional;

@RestController 
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @PostMapping
//    public Livro cadastrar (
    public ResponseEntity<Livro> cadastrar (
            @RequestBody Livro livroParaCadastrar
    ){
       Livro livroSalvo = this.repository.save(livroParaCadastrar);
//            return livroSalvo;
            return ResponseEntity.status(201).body(livroSalvo);
    }

    @GetMapping
//    public List<Livro> listar(){
    public ResponseEntity<List<Livro>> listar(){
        List<Livro> listaLivros = this.repository.findAll();

        if(listaLivros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listaLivros);
//        return this.repository.findAll();
    }

    @GetMapping("/{id}")
//    public Livro buscarPorId(@PathVariable Long id){
    public ResponseEntity<Livro> buscarPorId(@PathVariable int id){
        Optional<Livro> livro = this.repository.findById(id);

        if (livro.isPresent()) {
            return ResponseEntity.status(200).body(livro.get());
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizarLivro(@PathVariable int id, @RequestBody Livro livroParaAtualizar){

        if(this.repository.existsById(id)) {
            livroParaAtualizar.setId(id);
            Livro livroAtualizado = this.repository.save(livroParaAtualizar);
            return ResponseEntity.status(200).body(livroAtualizado);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable int id){
        if(this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/quantidade")
    public ResponseEntity<Long> buscarQuantidade(){
        Long total = this.repository.count();
        if(total > 0) {
            return ResponseEntity.status(200).body(total);
        }
        return ResponseEntity.status(204).build();
    }

    @GetMapping("/titulo")
    public ResponseEntity<List<Livro>> buscarPorTitulo(@RequestParam String titulo){
        List<Livro> livrosEncontrados = this.repository.findByTituloContainingIgnoreCase(titulo);

        if(livrosEncontrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(livrosEncontrados);
    }

//    private List<Livro> livros = new ArrayList<Livro>();
//    private int contador = 0;
//
//    @PostMapping
//    public Livro cadastrar (
//            @RequestBody Livro livroParaCadastrar
//    ){
//        livroParaCadastrar.setId(++contador);
//        livros.add(livroParaCadastrar);
//        return livroParaCadastrar;
//    }
//    @GetMapping
//    public List<Livro> listar(){
//        return livros;
//    }
//
//    @GetMapping("/{id}")
//    public Livro buscarPorId (@PathVariable int id) {
//        return this.livros.stream().filter(livro -> livro.getId() == id).findFirst().orElse(null);
//    }
//
//    @PutMapping("/{id}")
//    public Livro atualizar (
//            @PathVariable int id,
//            @RequestBody Livro livroParaAtualizar
//    ){
//        Optional<Livro> livroEncontrado = this.livros.stream()
//                .filter(livro -> livro.getId() == id).findFirst();
//        if(livroEncontrado.isPresent()){
//            Livro livro = livroEncontrado.get();
//            livro.setTitulo(livroParaAtualizar.getTitulo());
//            livro.setNomeAutor(livroParaAtualizar.getNomeAutor());
//            livro.setDataLancamento(livroParaAtualizar.getDataLancamento());
//            return livro;
//        }
//        return null;
//    }
//
//    @DeleteMapping("/{id}")
//    public void excluir (@PathVariable int id) {
//        this.livros.removeIf(livro -> livro.getId() == id);
//    }
}
