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
  @GetMapping("/{id}")
  public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id) {
    return ResponseEntity.ok(iPacienteService.buscarPorId(id));
  }

  @DeleteMapping("/eliminar/{id}")
  public ResponseEntity<String> eliminar(@PathVariable Integer id) {
    String response;
    if (iPacienteService.buscarPorId(id) == null) {
      response = "No es posible eliminar el registro ya que el id no existe";
    } else {
      iPacienteService.eliminar(id);
      response = "Registro eliminado corectamente";
    }
    return ResponseEntity.ok(response);
  }

  // listarTodos
  @GetMapping
  public ResponseEntity<List<Paciente>> listarTodos() {
    return ResponseEntity.ok(iPacienteService.listarTodos());
  }
}
