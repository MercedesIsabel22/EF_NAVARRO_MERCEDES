package com.example.EF_NAVARRO_MERCEDES.service;

import com.example.EF_NAVARRO_MERCEDES.model.Libro;
import com.example.EF_NAVARRO_MERCEDES.repository.GeneroRepository;
import com.example.EF_NAVARRO_MERCEDES.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private GeneroRepository generoRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    public Libro createLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro findById(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }
}
