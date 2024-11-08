package school.sptech.exerciciojpavalidation.service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.exerciciojpavalidation.entity.Evento;
import school.sptech.exerciciojpavalidation.repository.EventoRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public Evento buscarPorId(int id) {
        return repository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento não encontrado"));
    }

    public List<Evento> listar() {
        return repository.findAll();
    }

    public Evento cadastrar(@Valid Evento evento) {
        Evento eventoSalvo = repository.save(evento);
        return eventoSalvo;
    }

    public List<Evento> buscarGratuitos() {
        boolean b = true;
        return repository.findAllByGratuito(b);
    }

    public List<Evento> buscarPorData(LocalDate ocorrencia) {
        return repository.findByDataEventoOrDataPublicacao(ocorrencia, ocorrencia);
    }

}
