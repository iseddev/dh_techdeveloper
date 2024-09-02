package com.dh.Clase17S_APIRest_I.controller;

import com.dh.Clase17S_APIRest_I.model.Odontologo;
import com.dh.Clase17S_APIRest_I.service.IOdontologoService;
import com.dh.Clase17S_APIRest_I.service.impl.ImplOdontologoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // RestController -> API REST
@RequestMapping("/odontologos")
public class OdontologoController {

    private final IOdontologoService iOdontologoService;

    public OdontologoController() {
        this.iOdontologoService = new ImplOdontologoService();
    }

    //RequestParam => url ? parametro1 = X & parametro2 = X #-#-# PathVariable => url/pathVariable

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(iOdontologoService.buscarPorId(id));
    }

    // listarTodos
    @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos() {
        return ResponseEntity.ok(iOdontologoService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(iOdontologoService.guardar(odontologo));
    }
}