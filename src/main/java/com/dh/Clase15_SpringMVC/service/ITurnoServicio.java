package com.dh.Clase15_SpringMVC.service;

import com.dh.Clase15_SpringMVC.entity.Turno;
import java.util.List;

public interface ITurnoServicio {
    //crud
    Turno guardar(Turno turno);
    Turno consultarPorId(Long id);
    List<Turno> listarTodos();


}
