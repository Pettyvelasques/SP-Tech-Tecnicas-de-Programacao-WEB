package school.sptech.revisao_exception_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String primeiroNome;
    private String ultimoNome;
    @Email
    private String email;

    public Usuario() {
    }

    public Usuario(Integer id, String primeiroNome, String ultimoNome, String email) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", primeiroNome='" + primeiroNome + '\'' +
                ", ultimoNome='" + ultimoNome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
