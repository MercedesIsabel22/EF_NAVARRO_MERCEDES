package com.example.EF_NAVARRO_MERCEDES.repository;

import com.example.EF_NAVARRO_MERCEDES.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
