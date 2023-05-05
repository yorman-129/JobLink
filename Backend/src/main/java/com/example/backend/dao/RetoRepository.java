package com.example.backend.dao;

import com.example.backend.model.Reto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RetoRepository extends MongoRepository<Reto,String> {
}
