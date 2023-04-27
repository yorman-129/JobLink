package com.example.backend.dao;

import com.example.backend.model.Estudiante;

import java.util.List;

public interface EstudianteDao {
    List<Estudiante> getAll();

    void agregarEstudiante(Estudiante estudiante);

    List<Estudiante> getEstudiantesByNombre(String nombre);

    Estudiante getSingleEstudiante(String nombre);

}
