package com.dh.Clase15_SpringMVC.service;

import com.dh.Clase15_SpringMVC.entity.Odontologo;
import com.dh.Clase15_SpringMVC.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public interface IOdontologoServicio {

    Odontologo guardar (Odontologo odontologo);
    Odontologo buscarPorId(Long id) throws ResourceNotFoundException;
    String eliminar (Long id);
    Odontologo actualizar (Odontologo odontologo, Long id) throws ResourceNotFoundException;
    List<Odontologo> listarTodos();
    Odontologo buscarPorMatricula(String matricula);
}
