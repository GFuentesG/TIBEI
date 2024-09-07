package com.dh.Clase15_SpringMVC.service.Imp;


import com.dh.Clase15_SpringMVC.entity.Odontologo;
import com.dh.Clase15_SpringMVC.exception.ResourceNotFoundException;
import com.dh.Clase15_SpringMVC.repository.IOdontologoRepository;
import com.dh.Clase15_SpringMVC.service.IOdontologoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service                  //@Compoenet // porque lo esta manejando sprint
public class OdontologoServicioImpl implements IOdontologoServicio {
    @Autowired
    private IOdontologoRepository iOdontologoRepository;

    @Override
    public Odontologo guardar(Odontologo odontologo){

        return iOdontologoRepository.save(odontologo); //reemplazo a todo lo realizado antes en dao impl implementacionOdontologo
    }
    @Override
    public Odontologo buscarPorId(Long id) throws ResourceNotFoundException{
        Optional<Odontologo> odontologoBuscado = iOdontologoRepository.findById(id); // un opcional puede devolver un nulo
        if(odontologoBuscado.isPresent()){
            return odontologoBuscado.get();
        } else {
            //return null;  //aqui lanzaremos la excepcion
            throw new ResourceNotFoundException("No se encontro el Odontologo con id: " + id);
        }
    }

    @Override
    public String eliminar(Long id) {    //agregar un chequeo de que el id del odontologo exista para poder eliminarlo
        Optional<Odontologo> odontologoExistente = iOdontologoRepository.findById(id);
        if(odontologoExistente.isPresent()){
            iOdontologoRepository.deleteById(id);
            return ("Se elimino el odontologo con el id: " + id);
        } else {
            throw new ResourceNotFoundException("No se encontro al Odontologo con id: " + id + " para eliminarlo");
        }
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo, Long id) throws  ResourceNotFoundException{         //igual detectar que exista el id
        Optional<Odontologo> odontologoExistente = iOdontologoRepository.findById(id);
        if(odontologoExistente.isPresent()){
            odontologo.setId(id);
            return iOdontologoRepository.save(odontologo);
        } else {
            throw new ResourceNotFoundException("No se encontro al Odontologo con id: " + id + " para actualizarlo");
        }
    }

    @Override
    public List<Odontologo> listarTodos() {

        return iOdontologoRepository.findAll();
    }

    @Override
    public Odontologo buscarPorMatricula(String matricula) {
        return iOdontologoRepository.findByMatricula(matricula);
    }


}
