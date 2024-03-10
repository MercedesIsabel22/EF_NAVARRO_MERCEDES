package com.example.EF_NAVARRO_MERCEDES.repository;

import com.example.EF_NAVARRO_MERCEDES.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query(value = "SELECT * FROM libros l WHERE l.idgenero = :idGenero AND l.nombre LIKE LOWER(CONCAT('%', :nombre, '%'))", nativeQuery = true)
    List<Libro> findByNombreAndGenero(@Param("nombre") String nombre, @Param("idGenero") Long idGenero);
}
