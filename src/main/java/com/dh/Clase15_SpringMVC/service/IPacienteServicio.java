package com.dh.Clase15_SpringMVC.service;

import com.dh.Clase15_SpringMVC.entity.Paciente;

import java.util.List;

public interface IPacienteServicio {

    Paciente guardar (Paciente paciente);
    Paciente buscarPorId(Long id);
    List<Paciente> listarTodos();
    Paciente actualizar(Paciente paciente, Long id);
    String eliminar(Long id);

}
