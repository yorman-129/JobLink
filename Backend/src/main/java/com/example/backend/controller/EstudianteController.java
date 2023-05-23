package com.example.backend.controller;

import com.example.backend.model.Estudiante;
import com.example.backend.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static com.example.backend.configuration.StatusMessages.EMAIL_NOT_REGISTERED;


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
    public ResponseEntity<Object> guardarEstudiante(@RequestBody Estudiante estudiante) {
        return estudianteService.agregarEstudiante(estudiante);
    }

    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> login(@RequestBody HashMap<String, String> request) {
        String email = request.get("email");
        List<Estudiante> estudianteList = estudianteService.getAll();

        return estudianteList.stream()
                .anyMatch(estudiante -> estudiante.getEmail().equals(email)) ?
                estudianteService.login(email) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(EMAIL_NOT_REGISTERED);
    }
}
