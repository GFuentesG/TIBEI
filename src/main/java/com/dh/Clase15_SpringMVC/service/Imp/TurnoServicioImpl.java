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
    private ITurnoRepository iTurnoRepository;

//    public TurnoServicioImpl(){
//        this.iDao = new ImplementacionTurnoList();
//    }


    @Override
    public Turno guardar(Turno turno) {

        //debe haber aqui una logica de que si existe el odontologo y que exista el paciente
        //sino existe alguno de ellos, entonces que se lance una excepcion tipo BadRequest
        return iTurnoRepository.save(turno);
    }

    @Override
    public Turno consultarPorId(Long id) {
        Optional<Turno> turnoBuscado = iTurnoRepository.findById(id);

        if(!turnoBuscado.isPresent()){
            return null;
        } else{
            return turnoBuscado.get();
        }
        //otra forma en vez del if-else
        //return turnoBuscado.orElse(null);

    }

    @Override
    public List<Turno> listarTodos() {
        return iTurnoRepository.findAll();
    }
}
