package com.dh.Clase15_SpringMVC.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //incremental
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaAlta;
    @OneToOne(cascade = CascadeType.ALL)           //mapeando la relacion para que 1 paciente tenga 1 solo domicilio
    private Domicilio domicilio;     //con CascadeType.All es la contraparte para que sepa como es el proceso
                                    //cuando se crea un paciente, tmb se crea un domicilio
    @OneToMany (mappedBy =  "paciente")
    @JsonIgnore    //para que no haga un buble infinito. Se coloca desde donde se mapea
    private Set<Turno> turnoSet = new HashSet<>();
}
