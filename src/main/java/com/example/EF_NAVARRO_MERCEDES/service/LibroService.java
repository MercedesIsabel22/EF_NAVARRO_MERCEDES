package com.example.EF_NAVARRO_MERCEDES.service;

import com.example.EF_NAVARRO_MERCEDES.dto.LibroDTO;
import com.example.EF_NAVARRO_MERCEDES.model.Libro;
import com.example.EF_NAVARRO_MERCEDES.repository.GeneroRepository;
import com.example.EF_NAVARRO_MERCEDES.repository.LibroRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public JasperPrint exportReport(String report) throws FileNotFoundException, JRException {
        List<Libro> listLibro = libroRepository.findAll();
        File archivo = ResourceUtils.getFile(report);
        JasperReport jasperReport = JasperCompileManager.compileReport(archivo.getAbsolutePath());
        JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listLibro);
        Map<String,Object> parametros = new HashMap<>();
        JasperPrint print = JasperFillManager.fillReport(jasperReport, parametros,ds);
        return print;

    }
}
