package com.dh.Clase15_SpringMVC.service.Imp;


import com.dh.Clase15_SpringMVC.entity.Odontologo;
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
    public Odontologo buscarPorId(Long id){
        Optional<Odontologo> odontologoBuscado = iOdontologoRepository.findById(id); // un opcional puede devolver un nulo
        if(odontologoBuscado.isPresent()){
            return odontologoBuscado.get();
        } else {
            return null;
        }

    }

    @Override
    public void eliminar(Long id) {
        iOdontologoRepository.deleteById(id);

    }

    @Override
    public void actualizar(Odontologo odontologo) {
        iOdontologoRepository.save(odontologo);
    }

    @Override
    public List<Odontologo> listarTodos() {

        return iOdontologoRepository.findAll();
    }


}
