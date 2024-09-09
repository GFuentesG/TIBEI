package com.dh.Clase15_SpringMVC.service.Imp;

import com.dh.Clase15_SpringMVC.entity.Odontologo;
import com.dh.Clase15_SpringMVC.entity.Turno;
import com.dh.Clase15_SpringMVC.exception.BadRequestException;
import com.dh.Clase15_SpringMVC.exception.ResourceNotFoundException;
import com.dh.Clase15_SpringMVC.repository.IOdontologoRepository;
import com.dh.Clase15_SpringMVC.repository.ITurnoRepository;
import com.dh.Clase15_SpringMVC.service.ITurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TurnoServicioImpl implements ITurnoServicio {

    @Autowired
    private ITurnoRepository iTurnoRepository;

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Override
    public List<Odontologo> buscarOdontologosDisponibles(LocalDate fecha, LocalTime hora) throws BadRequestException {
        List<Odontologo> todosOdontologos = odontologoRepository.findAll();
        List<Turno> turnosEnEsaFechaYHora = iTurnoRepository.findByFechaAndHora(fecha, hora);

        // Si no hay odontólogos disponibles en la fecha y hora especificada, lanzamos una excepción
        if (todosOdontologos.isEmpty()) {
            throw new BadRequestException("No hay odontólogos disponibles en la fecha y hora especificada.");
        }

        // Obtener la lista de odontólogos ocupados en esa fecha y hora
        List<Odontologo> odontologosOcupados = turnosEnEsaFechaYHora.stream()
                .map(Turno::getOdontologo)
                .collect(Collectors.toList());

        // Filtrar odontólogos disponibles
        List<Odontologo> odontologosDisponibles = todosOdontologos.stream()
                .filter(odontologo -> !odontologosOcupados.contains(odontologo))
                .collect(Collectors.toList());

        // Si no hay odontólogos disponibles, lanzamos una excepción
        if (odontologosDisponibles.isEmpty()) {
            throw new BadRequestException("Todos los odontólogos están ocupados en la fecha y hora especificada.");
        }

        return odontologosDisponibles;
    }

    @Override
    public List<Turno> buscarDisponibilidadPorOdontologo(String odontologoNombre) throws ResourceNotFoundException, BadRequestException {
        // Validamos si el nombre del odontólogo es nulo o vacío
        if (odontologoNombre == null || odontologoNombre.isEmpty()) {
            throw new BadRequestException("El nombre del odontólogo no puede estar vacío.");
        }

        // Buscar el odontólogo por nombre
        Odontologo odontologo = odontologoRepository.findByNombre(odontologoNombre)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el odontólogo con nombre: " + odontologoNombre));

        // Buscar los turnos del odontólogo
        List<Turno> turnos = iTurnoRepository.findByOdontologo(odontologo);

        // Si el odontólogo no tiene turnos programados, lanzamos una excepción
        if (turnos.isEmpty()) {
            throw new BadRequestException("El odontólogo no tiene turnos disponibles.");
        }

        return turnos;
    }

    @Override
    public Turno guardar(String odontologoNombre, String pacienteNombre, String fecha, String hora) throws Exception {
        // Aquí se puede incluir la validación de datos y lanzamiento de BadRequestException
        // Lógica existente para guardar el turno
    }

    @Override
    public Turno consultarPorId(Long id) throws ResourceNotFoundException {
        return iTurnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el turno con ID: " + id));
    }

    @Override
    public List<Turno> listarTodos() {
        return iTurnoRepository.findAll();
    }
}
