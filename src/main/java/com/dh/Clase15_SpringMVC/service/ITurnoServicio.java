package com.dh.Clase15_SpringMVC.service;

import com.dh.Clase15_SpringMVC.entity.Odontologo;
import com.dh.Clase15_SpringMVC.entity.Turno;
import com.dh.Clase15_SpringMVC.exception.BadRequestException;
import com.dh.Clase15_SpringMVC.exception.ResourceNotFoundException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ITurnoServicio {

    List<Odontologo> buscarOdontologosDisponibles(LocalDate fecha, LocalTime hora) throws BadRequestException;

    List<Turno> buscarDisponibilidadPorOdontologo(String odontologoNombre) throws ResourceNotFoundException, BadRequestException;

    Turno guardar(String odontologoNombre, String pacienteNombre, String fecha, String hora) throws Exception;

    Turno consultarPorId(Long id) throws ResourceNotFoundException;

    List<Turno> listarTodos();
}
