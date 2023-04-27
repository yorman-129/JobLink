package com.example.backend.dao;

import com.example.backend.model.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
    Estudiante findByNombre(String nombre);
}
