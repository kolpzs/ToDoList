package com.pin.services;

import com.pin.entities.GrupoEntity;
import com.pin.entities.UserEntity;
import com.pin.repositories.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public GrupoEntity save(GrupoEntity grupo){
        return grupoRepository.save(grupo);
    }

    public GrupoEntity findById(Long id){
        return grupoRepository.findById(id).orElseThrow(()->new RuntimeException("Grupo not found"));
    }

    public List<GrupoEntity> findAll(){
        return grupoRepository.findAll();
    }

    public GrupoEntity update(GrupoEntity grupo){
        return grupoRepository.save(grupo);
    }

    public String delete(Long id){
        grupoRepository.deleteById(id);
        return  "Grupo deleted";
    }
}
