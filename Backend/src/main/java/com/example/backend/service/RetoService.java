package com.example.backend.service;

import com.example.backend.model.Reto;

import java.util.List;

public interface RetoService {
    List<Reto> getAllRetos();

    Reto agregarReto(Reto reto);

    void eliminarReto(Reto reto);
}
