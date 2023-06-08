package com.example.backend.controller;

import com.example.backend.dao.EstudianteRepository;
import com.example.backend.model.Estudiante;
import com.example.backend.model.Reto;
import com.example.backend.service.EstudianteService;
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
import org.springframework.web.multipart.MultipartRequest;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/retos")
public class RetoController {
  @Autowired RetoService retoService;
  @Autowired EstudianteService estudianteService;
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
    return retos.stream().filter(reto -> reto.getId().equals(id)).findFirst().orElse(null);
  }

  @PostMapping(value = "/{id}/solucion", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public void uploadRetoSolucion(
      @PathVariable String id, @RequestParam MultipartFile file, @RequestParam String mail) {
    try {
      byte[] solucion = file.getBytes();
      retoService.guardarSolucion(id, solucion, mail);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @GetMapping(value = "progreso/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Reto> retosByEmail(@PathVariable("email") String email) {

    List<Reto> retoList = retoService.getAllRetos();
    return Optional.ofNullable(retoList).orElse(Collections.emptyList()).stream()
        .filter(reto -> Objects.equals(reto.getMail(), email))
        .collect(Collectors.toList());
  }

  @GetMapping(value = "/{id}/solucion", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
  public ResponseEntity<Resource> downloadRetoSolucion(@PathVariable String id) {

    List<Reto> retoList = retoService.getAllRetos();

    String email =
        retoList.stream().filter(reto -> reto.getId().equals(id)).findFirst().get().getMail();
    String deletedDomain = email.replaceAll("@.*", "");

    byte[] solucion = retoService.obtenerSolucion(id);
    if (solucion != null) {
      ByteArrayResource resource = new ByteArrayResource(solucion);
      HttpHeaders headers = new HttpHeaders();
      headers.setContentDispositionFormData("attachment", deletedDomain+".zip");
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
