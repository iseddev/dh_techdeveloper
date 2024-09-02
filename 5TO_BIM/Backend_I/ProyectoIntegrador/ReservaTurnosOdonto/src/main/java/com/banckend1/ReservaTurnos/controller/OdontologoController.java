package com.banckend1.ReservaTurnos.controller;

import com.banckend1.ReservaTurnos.model.Odontologo;
import com.banckend1.ReservaTurnos.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/odonto")
public class OdontologoController {
    @Autowired
    private IOdontologoService odontoServ;

    //Crear un nuevo juego
    @PostMapping("/create")
    public ResponseEntity<Odontologo> guardarOdontologo(@RequestBody Odontologo odontologo) {
        Odontologo newOdontologo = odontoServ.guardar(odontologo);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOdontologo);
    }

    //Traer todos los juegos
    @GetMapping("/list")
    public ResponseEntity<List<Odontologo>> OdontoList() {
            List<Odontologo> listaOdonto = odontoServ.listarTodos();
            return ResponseEntity.ok(listaOdonto);
    }

    //Traer odontologo
    @GetMapping("/find/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Integer id){
        return ResponseEntity.ok(odontoServ.buscarPorId(id));
    }

    //Modificar los datos de un juego
    @PutMapping("/edit")
    public ResponseEntity<Odontologo>editarOdontologo(@RequestBody Odontologo updateOdonto) {
        odontoServ.actualizar(updateOdonto);
        return ResponseEntity.status(HttpStatus.OK).body(updateOdonto);
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> deleteGame(@PathVariable Integer id){
        odontoServ.eliminar(id);
        return ResponseEntity.noContent().build();
    }



}
