package com.example.backend.service;

import com.example.backend.dao.EstudianteRepository;
import com.example.backend.model.Estudiante;

import java.util.List;

public interface EstudianteService {
    List<Estudiante> getAll();

    Estudiante getEstudianteById(String id);


    Estudiante getSingleEstudiante(String nombre);

    Estudiante agregarEstudiante(Estudiante estudiante);
}
