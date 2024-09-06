package com.dh.Clase15_SpringMVC.exception;

//creamos nuestra propia excepcion
public class ResourceNotFoundException extends RuntimeException {   //para que el servicio maneje las excepciones y no el controlador
    public ResourceNotFoundException(String message) {  //creamos un constructor
        super(message);
    }
}
