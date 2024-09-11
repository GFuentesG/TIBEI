package com.dh.Clase15_SpringMVC.repository;

import com.dh.Clase15_SpringMVC.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {

    // Buscar un odontólogo por su matrícula
    Odontologo findByMatricula(String matricula);

    // Buscar un odontólogo por su nombre
    Optional<Odontologo> findByNombre(String nombre);
}
