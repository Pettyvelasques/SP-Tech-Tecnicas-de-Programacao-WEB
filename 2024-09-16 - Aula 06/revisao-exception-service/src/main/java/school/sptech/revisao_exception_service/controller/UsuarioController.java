package school.sptech.revisao_exception_service.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.revisao_exception_service.entity.Usuario;
import school.sptech.revisao_exception_service.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> resultado = service.listar();
        if(resultado.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(resultado);
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid Usuario usuario){
        Usuario usuarioSalvo = service.cadastrar(usuario);
        return ResponseEntity.status(201).body(usuarioSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable int id){
        Usuario usuario = this.service.buscarPorId(id);
        return ResponseEntity.status(200).body(usuario);
    }
}
