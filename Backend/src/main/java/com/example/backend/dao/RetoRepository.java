package com.example.backend.dao;

import com.example.backend.model.Reto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface RetoRepository extends MongoRepository<Reto,String> {
}
