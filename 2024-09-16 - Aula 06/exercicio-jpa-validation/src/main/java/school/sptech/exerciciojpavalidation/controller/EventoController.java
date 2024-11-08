package school.sptech.exerciciojpavalidation.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.exerciciojpavalidation.entity.Evento;
import school.sptech.exerciciojpavalidation.service.EventoService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService service;

    @PostMapping
    public ResponseEntity<Evento> cadastrar(@RequestBody @Valid Evento evento){
        Evento eventoSalvo = this.service.cadastrar(evento);
        return ResponseEntity.status(201).body(eventoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Evento>> listar(){
        List<Evento> eventos = service.listar();
        if(eventos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable int id){
        Evento evento = this.service.buscarPorId(id);
        return ResponseEntity.status(200).body(evento);
    }

    @GetMapping("/gratuitos")
    public ResponseEntity<List<Evento>> buscarGratuitos(){
        List<Evento> eventosGratuitos = service.buscarGratuitos();
        if(eventosGratuitos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(eventosGratuitos);
    }
    @GetMapping("/data")
    public ResponseEntity<List<Evento>> buscarPorData(@RequestParam("ocorrencia") LocalDate ocorrencia) {
        List<Evento> eventos = service.buscarPorData(ocorrencia);
        if (eventos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(eventos);
    }
}
