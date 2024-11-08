package school.sptech.exerciciojpavalidation.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Size(min = 5, max = 100)
    private String nome;
    @NotBlank
    @Size(min = 5, max = 150)
    private String local;
    @NotNull
    @FutureOrPresent
    private LocalDate dataEvento;
    private LocalDate dataPublicacao = LocalDate.now();
    private Boolean gratuito;
    private Boolean cancelado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Boolean getGratuito() {
        return gratuito;
    }

    public void setGratuito(Boolean gratuito) {
        this.gratuito = gratuito;
    }

    public Boolean getCancelado() { return cancelado; }

    public void setCancelado(Boolean cancelado) {
        this.cancelado = cancelado;
    }

    // Implementar o campo calculado
    public String getStatus() {

        if(getCancelado().equals(true)){
            return "CANCELADO";
        } else if(getDataEvento().isBefore(LocalDate.now())){
            return "FINALIZADO";
        }
            return "ABERTO";
    }
}
