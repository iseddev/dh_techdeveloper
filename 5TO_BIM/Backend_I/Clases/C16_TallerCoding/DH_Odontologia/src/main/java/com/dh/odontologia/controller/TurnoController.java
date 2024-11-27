package com.dh.odontologia.controller;

import com.dh.odontologia.model.Turno;
import com.dh.odontologia.service.IOdontologoService;
import com.dh.odontologia.service.IPacienteService;
import com.dh.odontologia.service.ITurnoService;
import com.dh.odontologia.service.implService.ImplOdontologoServ;
import com.dh.odontologia.service.implService.ImplPacienteServ;
import com.dh.odontologia.service.implService.ImplTurnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

  private final ITurnoService iTurnoService;
  private final IPacienteService iPacienteService;
  private final IOdontologoService iOdontologoService;

  public TurnoController() {
    this.iPacienteService = new ImplPacienteServ();
    this.iOdontologoService = new ImplOdontologoServ();
    this.iTurnoService = new ImplTurnoService();
  }

  @PostMapping
  public ResponseEntity<Turno> guardar(@RequestBody Turno turno) {
    return ResponseEntity.ok(iTurnoService.insertTurn(turno));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Turno> buscarPorId(@PathVariable Integer id) {
    // TODO que pasa si el id del paciente o del odontologo que recibe el turno no existen
    if (this.iPacienteService.getPatientById(id) == null || this.iOdontologoService.getDentistById(id) == null)
      return (ResponseEntity<Turno>) ResponseEntity.badRequest();
    else
      return ResponseEntity.ok(iTurnoService.getTurnById(id));
  }
}