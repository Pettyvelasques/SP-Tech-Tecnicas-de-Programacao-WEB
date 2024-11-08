package school.sptech.aula02;

public class Filme {

    private String titulo;
    private Diretor diretor;

    public Filme(String titulo, Diretor diretor) {
        this.titulo = titulo;
        this.diretor = diretor;
    }

    public String getPastel(){
        return "%s: Pastel de camarão".formatted(titulo);
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }
}