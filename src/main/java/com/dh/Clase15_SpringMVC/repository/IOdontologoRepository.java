package com.dh.Clase15_SpringMVC.repository;

import com.dh.Clase15_SpringMVC.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {  //aqui se hara las operaciones crud
                                            // con @idnetity no necesitaremos crear las tablas
                                            //esta linea reemplaza a toda la ImplementacionOdontologo
//    @Query("SELECT o FROM Odontologo o WHERE o.matricula = ?1")
    Odontologo findByMatricula (String matricula);  //usando HQL, en caso no se pueda, entonces usar jdbc como la linea anterior
}
