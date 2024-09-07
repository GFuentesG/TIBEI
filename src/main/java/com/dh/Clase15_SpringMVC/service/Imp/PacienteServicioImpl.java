package com.dh.Clase15_SpringMVC.service.Imp;

import com.dh.Clase15_SpringMVC.entity.Paciente;
import com.dh.Clase15_SpringMVC.exception.ResourceNotFoundException;
import com.dh.Clase15_SpringMVC.repository.IPacienteRepository;
import com.dh.Clase15_SpringMVC.service.IPacienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class PacienteServicioImpl implements IPacienteServicio {
    @Autowired
    private IPacienteRepository iPacienteRepository;



    //IDAO<Paciente> interfazIdao;  //aqui traemos la interfaz

//    public PacienteServicioImpl() {
//        this.interfazIdao = new ImplementacionPaciente(); //le decimos cual implementacion va a usar
//        //aqui podemos cambiar la implementacion a otra db
//    }

    @Override
    public Paciente guardar(Paciente paciente) {
        return iPacienteRepository.save(paciente);
    }

    @Override
    public Paciente buscarPorId(Long id) {
        Optional<Paciente> pacienteBuscado = iPacienteRepository.findById(id);
        if(!pacienteBuscado.isPresent()){
            return null;
        } else {
            return pacienteBuscado.get();
        }
    }

    @Override
    public List<Paciente> listarTodos() {
        return iPacienteRepository.findAll();
    }

    @Override
    public Paciente actualizar(Paciente paciente, Long id) throws ResourceNotFoundException {
        Optional<Paciente> pacienteExistente = iPacienteRepository.findById(id);
        if(pacienteExistente.isPresent()){
            paciente.setId(id);
            return iPacienteRepository.save(paciente);
        } else {
            throw new ResourceNotFoundException("no se encontro al Paciente con id: " + id + " para actualizarlo");
        }
    }

    @Override
    public String eliminar(Long id) throws ResourceNotFoundException{
        Optional<Paciente> pacienteExistente = iPacienteRepository.findById(id);
        if(pacienteExistente.isPresent()){
            iPacienteRepository.deleteById(id);
            return ("Se elimino al paciente con el id: " + id);
        } else {
            throw new ResourceNotFoundException("No se encontro al paciente con el id: " + id + " para eliminarlo");
        }
    }
}