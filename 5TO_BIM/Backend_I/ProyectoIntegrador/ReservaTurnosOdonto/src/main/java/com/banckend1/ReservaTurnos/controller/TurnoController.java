package com.banckend1.ReservaTurnos.controller;

import com.dh.C20S_InyeccionDependencias.model.Turno;
import com.dh.C20S_InyeccionDependencias.service.ITurnoService;
import com.dh.C20S_InyeccionDependencias.service.implementation.ImplTurnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private ITurnoService iTurnoService;

    public TurnoController() {
        this.iTurnoService = new ImplTurnoService();
    }

    @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno) {
        return ResponseEntity.ok(iTurnoService.guardar(turno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarPorId(@PathVariable Integer id) {

        //TODO que pasa si el id del paciente o del odontologo
        //que recibe el turno no existen
        return ResponseEntity.ok(iTurnoService.buscarPorId(id));
    }
}
