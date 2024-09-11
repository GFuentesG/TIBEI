package com.dh.Clase15_SpringMVC.repository;

import com.dh.Clase15_SpringMVC.entity.Odontologo;
import com.dh.Clase15_SpringMVC.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ITurnoRepository extends JpaRepository<Turno, Long> {

    List<Turno> findByFechaAndHora(LocalDate fecha, LocalTime hora);

    List<Turno> findByOdontologo(Odontologo odontologo);
}
