package com.dh.Clase15_SpringMVC.controller;

import com.dh.Clase15_SpringMVC.entity.Turno;
import com.dh.Clase15_SpringMVC.service.ITurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnoServicio turnoServicio;

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(turnoServicio.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoServicio.guardar(turno));
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTodos() {
        return ResponseEntity.ok(turnoServicio.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turno> actualizar(@PathVariable Long id, @RequestBody Turno turno) {
        return ResponseEntity.ok(turnoServicio.actualizar(turno, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        return ResponseEntity.ok(turnoServicio.eliminar(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Turno>> buscarPorOdontologoYPaciente(@RequestParam String nombreOdontologo, @RequestParam String nombrePaciente) {
        return ResponseEntity.ok(turnoServicio.buscarPorOdontologoYPaciente(nombreOdontologo, nombrePaciente));
    }
}
