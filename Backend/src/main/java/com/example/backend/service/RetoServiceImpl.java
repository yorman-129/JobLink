package com.example.backend.service;

import com.example.backend.dao.RetoRepository;
import com.example.backend.model.Reto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetoServiceImpl implements RetoService {
    @Autowired
    RetoRepository retoRepository;
    @Override
    public List<Reto> getAllRetos() {
        return retoRepository.findAll();
    }

    @Override
    public Reto agregarReto(Reto reto) {
        retoRepository.save(reto);
        return reto;
    }

    @Override
    public void eliminarReto(Reto reto) {
        retoRepository.delete(reto);
    }
}
