package com.pin.services;

import com.pin.entities.EventoEntity;
import com.pin.entities.GrupoEntity;
import com.pin.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public EventoEntity save(EventoEntity evento) {
        return eventoRepository.save(evento);
    }

    public EventoEntity findById(Long id) {
        return eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento not found"));
    }

    public List<EventoEntity> findAll() {
        return eventoRepository.findAll();
    }

    public EventoEntity update(EventoEntity evento) {
        return eventoRepository.save(evento);
    }

    public String delete(Long id) {
        eventoRepository.deleteById(id);
        return "Evento deleted";
    }
}
