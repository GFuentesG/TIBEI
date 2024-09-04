package com.dh.Clase15_SpringMVC.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity         //como se borro el DAO, con entity haremos que hibernate cree todo esto como una tabla
@Table(name = "domicilios")  //en la BD se llamara domicilios
@Getter @Setter  //lombok nos genera los getter y setter
@NoArgsConstructor  //nos genera el contructor sin parametros (aunque a mi no me salio error con ambos)
@AllArgsConstructor //genera el constructor con parametros (aunque a mi no me salio erorr con ambos)
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private Integer numero;
    private String localidad;
    private String provincia;

//    public Domicilio() {
//    }

//    public Domicilio(Long id, String calle, Integer numero, String localidad, String provincia) {
//        this.id = id;
//        this.calle = calle;
//        this.numero = numero;
//        this.localidad = localidad;
//        this.provincia = provincia;
//    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getCalle() {
//        return calle;
//    }
//
//    public void setCalle(String calle) {
//        this.calle = calle;
//    }
//
//    public Integer getNumero() {
//        return numero;
//    }
//
//    public void setNumero(Integer numero) {
//        this.numero = numero;
//    }
//
//    public String getLocalidad() {
//        return localidad;
//    }
//
//    public void setLocalidad(String localidad) {
//        this.localidad = localidad;
//    }
//
//    public String getProvincia() {
//        return provincia;
//    }
//
//    public void setProvincia(String provincia) {
//        this.provincia = provincia;
//    }
}
