package com.example.backend.service;

import com.example.backend.model.Reto;

import java.util.List;
import java.util.Optional;

public interface RetoService {
    List<Reto> getAllRetos();

    Reto buscarReto(String id);
    Reto agregarReto(Reto reto);

    void eliminarReto(Reto reto);
    void guardarSolucion(String id, byte[] solucion, String mail);
    byte[] obtenerSolucion(String id);

}
