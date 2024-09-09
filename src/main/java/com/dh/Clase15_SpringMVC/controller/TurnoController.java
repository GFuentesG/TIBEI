package com.dh.Clase15_SpringMVC.controller;

import com.dh.Clase15_SpringMVC.entity.Turno;
import com.dh.Clase15_SpringMVC.service.ITurnoServicio;
import com.dh.Clase15_SpringMVC.service.Imp.TurnoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private ITurnoServicio iTurnoServicio;


     @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno) throws BadRequestException, ResourceNotFoundException {
        // Aquí validamos si existen el paciente y el odontólogo
        return ResponseEntity.ok(iTurnoServicio.guardar(turno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> consultarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(iTurnoServicio.consultarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTodos() {
        return ResponseEntity.ok(iTurnoServicio.listarTodos());
    }
}
