package com.dh.Clase15_SpringMVC.service.Imp;

import com.dh.Clase15_SpringMVC.entity.Turno;
import com.dh.Clase15_SpringMVC.exception.BadRequestException;
import com.dh.Clase15_SpringMVC.exception.ResourceNotFoundException;
import com.dh.Clase15_SpringMVC.repository.IOdontologoRepository;
import com.dh.Clase15_SpringMVC.repository.IPacienteRepository;
import com.dh.Clase15_SpringMVC.repository.ITurnoRepository;
import com.dh.Clase15_SpringMVC.service.ITurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServicioImpl implements ITurnoServicio {

    @Autowired
    private ITurnoRepository iTurnoRepository;

    @Autowired
    private IOdontologoRepository odontologoRepository;

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Override
    public Turno guardar(Turno turno) throws BadRequestException, ResourceNotFoundException {
        // Validar si el odontólogo existe
        if (odontologoRepository.findById(turno.getOdontologo().getId()).isEmpty()) {
            throw new ResourceNotFoundException("No se encontró el odontólogo con ID: " + turno.getOdontologo().getId());
        }
        // Validar si el paciente existe
        if (pacienteRepository.findById(turno.getPaciente().getId()).isEmpty()) {
            throw new ResourceNotFoundException("No se encontró el paciente con ID: " + turno.getPaciente().getId());
        }
        // Validar si el odontólogo ya tiene un turno en la misma fecha y hora
        List<Turno> turnosDelOdontologo = iTurnoRepository.findByOdontologoIdAndFechaAndHora(
                turno.getOdontologo().getId(),
                turno.getFecha(),
                turno.getHora()
        );
        if (!turnosDelOdontologo.isEmpty()) {
            throw new BadRequestException("El odontólogo ya tiene un turno asignado en esa fecha y hora.");
        }

        return iTurnoRepository.save(turno);
    }

    @Override
    public Turno consultarPorId(Long id) throws ResourceNotFoundException {
        Optional<Turno> turnoBuscado = iTurnoRepository.findById(id);
        return turnoBuscado.orElseThrow(() -> new ResourceNotFoundException("No se encontró el turno con ID: " + id));
    }

    @Override
    public List<Turno> listarTodos() {
        return iTurnoRepository.findAll();
    }
}

