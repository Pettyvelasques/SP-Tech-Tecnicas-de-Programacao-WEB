package school.sptech.revisao_exception_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.revisao_exception_service.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    boolean existsByEmail(String email);
}
