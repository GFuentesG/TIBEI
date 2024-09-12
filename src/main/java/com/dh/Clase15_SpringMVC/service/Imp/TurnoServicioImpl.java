package com.dh.Clase15_SpringMVC.service.Imp;

import com.dh.Clase15_SpringMVC.entity.Turno;
import com.dh.Clase15_SpringMVC.repository.ITurnoRepository;
import com.dh.Clase15_SpringMVC.service.ITurnoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServicioImpl implements ITurnoServicio {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Override
    public Turno guardar(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public Turno buscarPorId(Long id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        return turno.orElse(null);
    }

    @Override
    public List<Turno> listarTodos() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno actualizar(Turno turno, Long id) {
        if (turnoRepository.existsById(id)) {
            turno.setId(id);
            return turnoRepository.save(turno);
        }
        return null;
    }

    @Override
    public String eliminar(Long id) {
        turnoRepository.deleteById(id);
        return "Turno eliminado exitosamente";
    }

    @Override
    public List<Turno> buscarPorOdontologoYPaciente(String nombreOdontologo, String nombrePaciente) {
        return turnoRepository.findByOdontologo_NombreAndPaciente_Nombre(nombreOdontologo, nombrePaciente);
    }
}
