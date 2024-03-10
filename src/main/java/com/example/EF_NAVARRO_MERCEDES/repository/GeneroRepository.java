package com.example.EF_NAVARRO_MERCEDES.repository;

import com.example.EF_NAVARRO_MERCEDES.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Optional<Genero> findByNombre(String nombre);
}
