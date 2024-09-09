package com.dh.Clase15_SpringMVC.controller;

import com.dh.Clase15_SpringMVC.entity.Odontologo;
import com.dh.Clase15_SpringMVC.entity.Turno;
import com.dh.Clase15_SpringMVC.exception.BadRequestException;
import com.dh.Clase15_SpringMVC.exception.ResourceNotFoundException;
import com.dh.Clase15_SpringMVC.service.ITurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private ITurnoServicio iTurnoServicio;

    @GetMapping("/disponibles")
    public ResponseEntity<List<Odontologo>> buscarOdontologosDisponibles(
            @RequestParam("fecha") String fecha,
            @RequestParam("hora") String hora) throws BadRequestException, ResourceNotFoundException {
        
        List<Odontologo> odontologosDisponibles = iTurnoServicio.buscarOdontologosDisponibles(
                LocalDate.parse(fecha), LocalTime.parse(hora));
        return ResponseEntity.ok(odontologosDisponibles);
    }

    @GetMapping("/disponibilidad")
    public ResponseEntity<List<Turno>> buscarDisponibilidadOdontologo(
            @RequestParam("odontologoNombre") String odontologoNombre) throws ResourceNotFoundException, BadRequestException {

        List<Turno> turnos = iTurnoServicio.buscarDisponibilidadPorOdontologo(odontologoNombre);
        return ResponseEntity.ok(turnos);
    }

    @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Map<String, String> request) throws Exception {
        String odontologoNombre = request.get("odontologoNombre");
        String pacienteNombre = request.get("pacienteNombre");
        String fecha = request.get("fecha");
        String hora = request.get("hora");

        Turno turno = iTurnoServicio.guardar(odontologoNombre, pacienteNombre, fecha, hora);
        return ResponseEntity.ok(turno);
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

