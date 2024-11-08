package school.sptech.webaula3.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Livro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String nomeAutor;
    private LocalDate dataLancamento;

    public Livro(int id, String titulo, String nomeAutor, LocalDate dataLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.dataLancamento = dataLancamento;
    }

    public Livro() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", nomeAutor='" + nomeAutor + '\'' +
                ", dataLancamento=" + dataLancamento +
                '}';
    }
}
