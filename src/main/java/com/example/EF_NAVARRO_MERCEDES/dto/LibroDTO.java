package com.example.EF_NAVARRO_MERCEDES.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class LibroDTO {
    private Long id;
    private String nombre;
    private String autor;
    private String genero;
    private String fechaPublicacion;
    private String fechaRegistro;

}
