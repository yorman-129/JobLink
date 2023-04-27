package com.example.backend.dao;

import com.example.backend.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EstudianteDaoImpl implements EstudianteDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired EstudianteRepository estudianteRepository;
    @Override
    public List<Estudiante> getAll() {
        return mongoTemplate.findAll(Estudiante.class);
    }

    @Override
    public void agregarEstudiante(Estudiante estudiante) {
        if (estudiante.getNombre() == null || estudiante.getEmail() == null) {
            throw new IllegalArgumentException("Nombre y correo electrónico son campos requeridos");
        }
        estudianteRepository.save(estudiante);
    }

    @Override
    public List<Estudiante> getEstudiantesByNombre(String nombre) {
        Query query = new Query();
        query.addCriteria(Criteria.where("nombre").is(nombre));
        return new ArrayList<>(mongoTemplate.find(query, Estudiante.class));
    }

    @Override
    public Estudiante getSingleEstudiante(String nombre) {
        Query query = new Query();
        query.addCriteria(Criteria.where("nombre").is(nombre));
        return mongoTemplate.findOne(query, Estudiante.class);
    }
}
