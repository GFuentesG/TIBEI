package com.dh.Clase15_SpringMVC.controller;

import com.dh.Clase15_SpringMVC.entity.Paciente;
import com.dh.Clase15_SpringMVC.service.IPacienteServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private IPacienteServicio iPacienteServicio;
//    public PacienteController(){
//        iPacienteServicio = new PacienteServicioImpl();
//    }

    public PacienteController(IPacienteServicio iPacienteServicio) {   //inyectado y no hace falta el @autoware
        this.iPacienteServicio = iPacienteServicio;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> consultarPorId(@PathVariable Long id){
        return  ResponseEntity.ok(iPacienteServicio.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Paciente> guardar(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(iPacienteServicio.guardar(paciente));
    }

}
