package com.example.backend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@Builder
public class Reto implements Serializable {
    @Id
    String id;
    Empresa empresa;
    String descripcion;
    String dificultad;
}
