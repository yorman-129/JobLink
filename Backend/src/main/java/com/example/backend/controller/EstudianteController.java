package com.example.backend.controller;

import com.example.backend.model.Estudiante;
import com.example.backend.service.EstudianteService;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping(value = "/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Estudiante getEstudianteByNombre(@PathVariable String nombre) {
        return estudianteService.getSingleEstudiante(nombre);
    }

    @PostMapping(value = "agregar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String guardarEstudiante(@RequestBody Estudiante estudiante) {
        return String.valueOf(estudianteService.agregarEstudiante(estudiante));
    }

    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> login(@RequestBody String email) {
       return estudianteService.login(email);
    }
}
