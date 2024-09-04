package com.dh.Clase15_SpringMVC.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity             //          por el momento
//@Table(name = "turnos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turno {

    @Id
    private Long id;
//    private Odontologo odontologo;
    @ManyToOne
    private Paciente paciente;
    private LocalDate fecha;
    private LocalTime hora;   //45:30




}
