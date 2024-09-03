package com.dh.Clase15_SpringMVC.controller;

import com.dh.Clase15_SpringMVC.modelo.Turno;
import com.dh.Clase15_SpringMVC.servicio.IOdontologoServicio;
import com.dh.Clase15_SpringMVC.servicio.IPacienteServicio;
import com.dh.Clase15_SpringMVC.servicio.ITurnoServicio;
import com.dh.Clase15_SpringMVC.servicio.impl.OdontologoServicioImpl;
import com.dh.Clase15_SpringMVC.servicio.impl.PacienteServicioImpl;
import com.dh.Clase15_SpringMVC.servicio.impl.TurnoServicioImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

  private final ITurnoServicio iTurnoServicio;
  private final IPacienteServicio iPacienteServicio;
  private final IOdontologoServicio iOdontologoServicio;

  public TurnoController() {
    this.iPacienteServicio = new PacienteServicioImpl();
    this.iOdontologoServicio = new OdontologoServicioImpl();
    this.iTurnoServicio = new TurnoServicioImpl();
  }

  @PostMapping
  public ResponseEntity<Turno> guardar(@RequestBody Turno turno) {
    return ResponseEntity.ok(iTurnoServicio.guardar(turno));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Turno> buscarPorId(@PathVariable Integer id) {
    // TODO que pasa si el id del paciente o del odontologo que recibe el turno no existen
    if (this.iPacienteServicio.buscarPorId(id) == null || this.iOdontologoServicio.buscarPorId(id) == null)
      return (ResponseEntity<Turno>) ResponseEntity.badRequest();
    else
      return ResponseEntity.ok(iTurnoServicio.buscarPorId(id));
  }
}