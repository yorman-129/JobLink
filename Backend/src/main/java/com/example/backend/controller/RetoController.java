package com.example.backend.controller;

import com.example.backend.dao.EstudianteRepository;
import com.example.backend.model.Reto;
import com.example.backend.service.RetoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/retos")
public class RetoController {
    @Autowired
    RetoService retoService;
    @Autowired
    private EstudianteRepository estudianteRepository;

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteReto(@PathVariable String id) {
        estudianteRepository.deleteById(id);
    }

    @PostMapping(value = "agregar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Reto agregarReto(@RequestBody Reto reto) {
        return retoService.agregarReto(reto);
    }

    @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Reto> findAll() {
        return retoService.getAllRetos();
    }

    @GetMapping(value = "find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Reto findId(@PathVariable("id") String id) {
        List<Reto> retos = retoService.getAllRetos();
        System.out.println(retos.get(0).getDescripcion());
        return retos.stream().filter(reto -> reto.getId().equals(id)).findFirst().orElse(null);
    }
}
