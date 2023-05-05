package com.example.backend.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
@Data
@Builder
public class Empresa implements Serializable {
    @Id
    String id;
    String nombre;
    String direccion;
    String telefono;
}
