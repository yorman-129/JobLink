package com.example.backend.dao;

import com.example.backend.model.Reto;

import java.util.List;

public interface RetoDao {
    List<Reto> getAllRetos();
    Reto buscarReto(String id);
    void agregarReto(Reto reto);
    void eliminarReto(Reto reto);
    List<Reto> obtenerRetos();
    void guardarSolucion(String id, byte[] solucion);
    byte[] obtenerSolucion(String id);
}
