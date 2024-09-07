package com.dh.Clase15_SpringMVC.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //pq se agrego la dependencia de jpa // y hay que decirle cual es el primary Key
@Table(name = "odontologos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Odontologo {
    @Id     //le decimos que es la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //estrategia de generacion de valor
    private Long id;
//    @Column(name = "name")  //aunque ya no es necesario pq creara @Entity @Table una tabla
                            //con los nombres de los atributos, excepto si especificamos un
                            //nombre particular como el name
    private String nombre;
    private String apellido;
    private String matricula;

}
