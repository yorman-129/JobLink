package com.example.backend.controller;

import com.example.backend.dao.EstudianteRepository;
import com.example.backend.model.Reto;
import com.example.backend.service.RetoService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/retos")
public class RetoController {
  @Autowired RetoService retoService;
  @Autowired private EstudianteRepository estudianteRepository;

  @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public void deleteReto(@PathVariable String id) {
    estudianteRepository.deleteById(id);
  }

  @PostMapping(
      value = "agregar",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Reto agregarReto(@RequestBody Reto reto) {
    return retoService.agregarReto(reto);
  }

  @GetMapping(value = "all", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Reto> findAll() {
    return retoService.getAllRetos();
  }

  @GetMapping(value = "find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Reto findId(@PathVariable("id") String id) {
    List<Reto> retos = retoService.getAllRetos();
    System.out.println(retos.get(0).getDescripcion());
    return retos.stream().filter(reto -> reto.getId().equals(id)).findFirst().orElse(null);
  }

  @PostMapping(value = "/{id}/solucion", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public void uploadRetoSolucion(@PathVariable String id, @RequestParam MultipartFile file) {
    try {
      byte[] solucion = file.getBytes();
      retoService.guardarSolucion(id, solucion);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

    @GetMapping(value = "/{id}/solucion", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadRetoSolucion(@PathVariable String id) {
        byte[] solucion = retoService.obtenerSolucion(id);
        if (solucion != null) {
            ByteArrayResource resource = new ByteArrayResource(solucion);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment", "solucion.zip");
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentLength(solucion.length)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
