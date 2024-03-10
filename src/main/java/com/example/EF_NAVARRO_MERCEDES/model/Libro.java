package com.example.EF_NAVARRO_MERCEDES.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 4, max =60)
    @NotNull
    private String nombre;
    @Size(min = 4, max =60)
    @NotNull
    private String autor;
    @NotNull
    private Date fechaPublicacion;
    private LocalDate fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "idGenero", nullable = false)
    public Genero genero;
}
