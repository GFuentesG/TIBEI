package com.dh.Clase15_SpringMVC.service;

import com.dh.Clase15_SpringMVC.entity.Turno;

import java.util.List;

public interface ITurnoServicio {
    Turno guardar(Turno turno);
    Turno buscarPorId(Long id);
    String eliminar(Long id);
    Turno actualizar(Turno turno, Long id);
    List<Turno> listarTodos();
    List<Turno> buscarPorOdontologoYPaciente(String nombreOdontologo, String nombrePaciente);
}
