package com.example.backend.dao;

import com.example.backend.model.Reto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RetoDaoImpl implements RetoDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public List<Reto> getAllRetos() {
        return mongoTemplate.findAll(Reto.class);
    }

    @Override
    public void agregarReto(Reto reto) {
        if (reto.getDificultad() == null || reto.getEmpresa() == null) {
            throw new IllegalArgumentException("Dificultad y empresa son campos requeridos");
        }
        mongoTemplate.save(reto);
    }

    @Override
    public void eliminarReto(Reto reto) {
        Query query = new Query(Criteria.where("id").is(reto.getId()));
        mongoTemplate.remove(query, Reto.class);
    }
}
