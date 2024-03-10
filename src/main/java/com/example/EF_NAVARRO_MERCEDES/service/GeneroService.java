package com.example.EF_NAVARRO_MERCEDES.service;

import com.example.EF_NAVARRO_MERCEDES.model.Genero;
import com.example.EF_NAVARRO_MERCEDES.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {
    @Autowired
    private GeneroRepository generoRepository;
    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }
    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }
    public List<Genero> getAllGeneros(){
        return generoRepository.findAll();
    }

    public Genero findById(Long id) {
        return generoRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        generoRepository.deleteById(id);
    }

}
