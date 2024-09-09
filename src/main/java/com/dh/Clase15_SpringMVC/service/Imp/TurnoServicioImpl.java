package com.dh.Clase15_SpringMVC.service.Imp;

import com.dh.Clase15_SpringMVC.entity.Odontologo;
import com.dh.Clase15_SpringMVC.entity.Turno;
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
    public List<Odontologo> buscarOdontologosDisponibles(LocalDate fecha, LocalTime hora) {
        List<Odontologo> todosOdontologos = odontologoRepository.findAll();
        List<Turno> turnosEnEsaFechaYHora = iTurnoRepository.findByFechaAndHora(fecha, hora);

        // Obtener la lista de odontólogos ocupados en esa fecha y hora
        List<Odontologo> odontologosOcupados = turnosEnEsaFechaYHora.stream()
                .map(Turno::getOdontologo)
                .collect(Collectors.toList());

        // Filtrar odontólogos disponibles
        return todosOdontologos.stream()
                .filter(odontologo -> !odontologosOcupados.contains(odontologo))
                .collect(Collectors.toList());
    }

    @Override
    public List<Turno> buscarDisponibilidadPorOdontologo(String odontologoNombre) throws ResourceNotFoundException {
        Odontologo odontologo = odontologoRepository.findByNombre(odontologoNombre)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el odontólogo con nombre: " + odontologoNombre));

        return iTurnoRepository.findByOdontologo(odontologo);
    }

    @Override
    public Turno guardar(String odontologoNombre, String pacienteNombre, String fecha, String hora) throws Exception {
        // Lógica para guardar el turno
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
