package com.dh.Clase15_SpringMVC.repository;

import com.dh.Clase15_SpringMVC.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
    List<Turno> findByOdontologo_NombreAndPaciente_Nombre(String nombreOdontologo, String nombrePaciente);
}
