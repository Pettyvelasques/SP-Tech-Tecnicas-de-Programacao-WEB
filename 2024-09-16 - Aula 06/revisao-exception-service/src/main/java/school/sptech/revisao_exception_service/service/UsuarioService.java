package school.sptech.revisao_exception_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.revisao_exception_service.entity.Usuario;
import school.sptech.revisao_exception_service.exception.EntidadeConflitoException;
import school.sptech.revisao_exception_service.exception.EntidadeNaoEncontradaException;
import school.sptech.revisao_exception_service.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

//    Controller Advice (Exception Handler):
//        Padronização de respostas
//        Mapemaento de exceptions personalizadas

    public List<Usuario> listar(){
        return repository.findAll();
    }

    public Usuario cadastrar(Usuario usuario){

        if(repository.existsByEmail(usuario.getEmail())){
//            É do Spring, é para retornar algo na request
            throw new EntidadeConflitoException("Usuário já existe");
        }
        Usuario usuarioSalvo = repository.save(usuario);
        return usuarioSalvo;
    }

    public Usuario buscarPorId(int id){
        return repository.findById(id).orElseThrow( () -> new EntidadeNaoEncontradaException("Usuário não encontrado"));

//        Optional<Usuario> provavelUsuario = this.repository.findById(id);
//
//        if(provavelUsuario.isEmpty()){
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
//        }
//
//        return provavelUsuario.get();
    }
}
