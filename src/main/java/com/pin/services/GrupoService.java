package com.pin.services;

import com.pin.entities.GrupoEntity;
import com.pin.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public GrupoEntity save(GrupoEntity grupo) {
        return grupoRepository.save(grupo);
    }

    public GrupoEntity findById(Long id) {
        return grupoRepository.findById(id).orElseThrow(() -> new RuntimeException("Grupo not found"));
    }

    public List<List<GrupoEntity>> findAll() {
        List<GrupoEntity> total = grupoRepository.findAll();
        List<List<GrupoEntity>> separados = new ArrayList<>();

        for (int i = 0; i < total.size(); i += 20) {
            List<GrupoEntity> subLista = total.subList(i, Math.min(i + 20, total.size()));
            separados.add(new ArrayList<>(subLista));
        }

        return separados;
    }

    public GrupoEntity update(GrupoEntity grupo) {
        return grupoRepository.save(grupo);
    }

    public String delete(Long id) {
        grupoRepository.deleteById(id);
        return "Grupo deleted";
    }
}
