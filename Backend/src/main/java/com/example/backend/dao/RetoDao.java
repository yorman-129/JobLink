package com.example.backend.dao;

import com.example.backend.model.Reto;

import java.util.List;

public interface RetoDao {
    List<Reto> getAllRetos();

    void agregarReto(Reto reto);
    void eliminarReto(Reto reto);

    List<Reto> obtenerRetos();

}
