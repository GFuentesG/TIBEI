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
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno){
        return ResponseEntity.ok(iTurnoServicio.guardar(turno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> consultarPorId(@PathVariable Long id){
        return ResponseEntity.ok(iTurnoServicio.consultarPorId(id));// ver cuando es nulo el lugar del id, del paciente,o odontologo, conun if que busque por id odontolo como servicio
    }

}
