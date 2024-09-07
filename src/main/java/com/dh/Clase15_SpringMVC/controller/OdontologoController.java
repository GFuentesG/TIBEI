package com.dh.Clase15_SpringMVC.controller;

import com.dh.Clase15_SpringMVC.entity.Odontologo;
import com.dh.Clase15_SpringMVC.service.IOdontologoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    private IOdontologoServicio odontologoServicio;
    //RequestParam url?parametro=x&parametro=x
    //PathVariable ruta que puede estar cambiando
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(odontologoServicio.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Odontologo> guardar(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoServicio.guardar(odontologo));
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> listarTodos(){
        return ResponseEntity.ok(odontologoServicio.listarTodos());
    }

    @GetMapping("/matricula/{matricula}")
    public ResponseEntity<Odontologo> buscarPorMatricula(@PathVariable String matricula){
        return ResponseEntity.ok(odontologoServicio.buscarPorMatricula(matricula));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Odontologo> actualizar(@PathVariable Long id, @RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoServicio.actualizar(odontologo, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id){
        return ResponseEntity.ok(odontologoServicio.eliminar(id));
    }
    
}
