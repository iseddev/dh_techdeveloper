package com.dh.Clase17S_APIRest_I.controller;

import com.dh.Clase17S_APIRest_I.model.Odontologo;
import com.dh.Clase17S_APIRest_I.model.Paciente;
import com.dh.Clase17S_APIRest_I.service.IPacienteService;
import com.dh.Clase17S_APIRest_I.service.impl.ImplPacienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // RestController -> API REST
@RequestMapping("/pacientes")
public class PacienteController {

  private final IPacienteService iPacienteService;

  public PacienteController() { this.iPacienteService = new ImplPacienteService(); }

  //RequestParam => url ? parametro1 = X & parametro2 = X #-#-# PathVariable => url/pathVariable

  // buscarPorId
  @GetMapping("/buscarId/{id}")
  public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id) {
    return ResponseEntity.ok(iPacienteService.buscarPorId(id));
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> eliminar(@PathVariable Integer id) {
    iPacienteService.eliminar(id);
    return ResponseEntity.ok("Registro eliminado correctamente");
  }

  // listarTodos
  @GetMapping
  public ResponseEntity<List<Paciente>> listarTodos() {
    return ResponseEntity.ok(iPacienteService.listarTodos());
  }

  @PostMapping
  public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
    return ResponseEntity.ok(iPacienteService.guardar(paciente));
  }
}