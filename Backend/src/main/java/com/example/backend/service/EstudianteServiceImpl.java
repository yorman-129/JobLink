package com.example.backend.service;

import com.example.backend.dao.EstudianteRepository;
import com.example.backend.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public List<Estudiante> getAll() {
        return estudianteRepository.findAll();
    }

    @Override
    public Estudiante getEstudianteById(String id) {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudiantes.stream()
                .filter(estudiante -> id.equals(estudiante.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Estudiante getSingleEstudiante(String nombre) {
        return estudianteRepository.findByNombre(nombre);
    }

    @Override
    public Estudiante agregarEstudiante(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
        return estudiante;
    }
}
