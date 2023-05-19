package com.example.backend.service;

import com.example.backend.dao.RetoDaoImpl;
import com.example.backend.dao.RetoRepository;
import com.example.backend.model.Reto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetoServiceImpl implements RetoService {
    @Autowired
    RetoDaoImpl retoDao;

    @Override
    public List<Reto> getAllRetos() {
        return retoDao.getAllRetos();
    }

    @Override
    public Reto buscarReto(String id) {
        return retoDao.buscarReto(id);
    }


    @Override
    public Reto agregarReto(Reto reto) {
        retoDao.agregarReto(reto);
        return reto;
    }

    @Override
    public void eliminarReto(Reto reto) {
        retoDao.eliminarReto(reto);
    }

}
