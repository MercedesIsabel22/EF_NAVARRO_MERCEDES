package com.example.EF_NAVARRO_MERCEDES.controller;

import com.example.EF_NAVARRO_MERCEDES.model.Genero;
import com.example.EF_NAVARRO_MERCEDES.model.Libro;
import com.example.EF_NAVARRO_MERCEDES.service.GeneroService;
import com.example.EF_NAVARRO_MERCEDES.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/libro")
public class LibroController {
    @Autowired
    private LibroService libroService;
    @Autowired
    private GeneroService generoService;

    @GetMapping("/Libros")
    public String getAllLibros(Model model) {

        List<Libro> lisLibros = libroService.getAllLibros();

        for (Libro libro : lisLibros) {
            System.out.println(libro.getId());
            System.out.println(libro.getNombre());
            System.out.println(libro.getAutor());
            System.out.println(libro.getFechaPublicacion());
            System.out.println(libro.getGenero().getId());
            System.out.println(libro.getGenero().getNombre());
        }
        model.addAttribute("libros", lisLibros);
        return "libroList";
    }
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("generos", generoService.getAllGeneros());
        return "LibroRegister";
    }
    @PostMapping("/save")
    public String save(@RequestParam("libro")String nombre, @RequestParam ("autor")String autor,
                       @RequestParam ("fecha") String fechaPublicacion, @RequestParam ("idGenero")String genero, Model model) throws ParseException {
        Genero objGenero = generoService.findById(Long.valueOf(genero));
        Libro libros = new Libro();
        libros.setNombre(nombre);
        libros.setAutor(autor);
        SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
        Date fechaDate = formato.parse(fechaPublicacion);
        libros.setFechaPublicacion(fechaDate);
        libros.setGenero(objGenero);

        libroService.createLibro(libros);
        List<Libro> listLibros = libroService.getAllLibros();
        model.addAttribute("libros", listLibros );
        return "libroList";

    }
    @GetMapping("/edit/{id}")
    public String getLibroByID(@PathVariable Long id, Model model) {
        Libro libro = libroService.findById(id);
        model.addAttribute("libro", libro);
        model.addAttribute("generos", generoService.getAllGeneros());
        return "libroEdit";
    }
    @PostMapping("/edit")
    public String editLibro(@RequestParam("id") Long id, @RequestParam("libro") String nombre, @RequestParam("autor") String autor,
                               @RequestParam("idGenero") Long idGenero,  Model model) {
        Genero gnr = generoService.findById(idGenero);
        Libro obj = libroService.findById(id);
        obj.setNombre(nombre);
        obj.setAutor(autor);
        obj.setGenero(gnr);

        libroService.createLibro(obj);

        List<Libro> listLibros = libroService.getAllLibros();
        model.addAttribute("libros", listLibros );
        return "libroList";
    }
    @GetMapping("/delete/{id}")
    public String deleteLibro(@PathVariable Long id, Model model) {
        libroService.deleteById(id);

        List<Libro> listLibro = libroService.getAllLibros();
        model.addAttribute("libros", listLibro);

        return "libroList";
    }

}
