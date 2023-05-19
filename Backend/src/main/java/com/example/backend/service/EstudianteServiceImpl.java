package com.example.backend.service;

import com.example.backend.dao.EstudianteDaoImpl;
import com.example.backend.dao.EstudianteRepository;
import com.example.backend.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    private static final String EMAIL_REGEX = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.edu\\.co\\b";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    @Autowired
    private EstudianteDaoImpl estudianteDao;

    @Override
    public List<Estudiante> getAll() {
        return estudianteDao.getAll();
    }

    @Override
    public Estudiante getEstudianteById(String id) {
        List<Estudiante> estudiantes = estudianteDao.getAll();
        return estudiantes.stream()
                .filter(estudiante -> id.equals(estudiante.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Estudiante getSingleEstudiante(String nombre) {
        return estudianteDao.getSingleEstudiante(nombre);
    }

    @Override
    public Estudiante agregarEstudiante(Estudiante estudiante) {
        estudianteDao.agregarEstudiante(estudiante);
        return estudiante;
    }

    @Override
    public ResponseEntity<Object> login(String email) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Email inválido");
        email = email.replace("\"", "");
        email = email.replace("\r", "").replace("\n", "");
        if (email != null && EMAIL_PATTERN.matcher(email).matches()) {
            response.put("message", "Email válido");
            return ResponseEntity.ok().body(response);
        } else {
            return ResponseEntity.badRequest().body(response);
        }
    }
}
