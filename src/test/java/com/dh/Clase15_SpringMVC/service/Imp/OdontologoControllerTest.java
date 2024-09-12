package com.dh.Clase15_SpringMVC.controller;

import com.dh.Clase15_SpringMVC.entity.Odontologo;
import com.dh.Clase15_SpringMVC.service.IOdontologoServicio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OdontologoController.class)
class OdontologoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IOdontologoServicio odontologoServicio;

    @Test
    void testBuscarPorMatricula() throws Exception {
        // Simular la respuesta del servicio de odontólogo
        Odontologo odontologo = new Odontologo();
        odontologo.setId(1L);
        odontologo.setNombre("Juan");
        odontologo.setApellido("Pérez");
        odontologo.setMatricula("12345");

        // Cuando se llame al servicio para buscar por matrícula, devolver el odontólogo simulado
        Mockito.when(odontologoServicio.buscarPorMatricula("12345")).thenReturn(odontologo);

        // Realizar la solicitud GET y verificar la respuesta
        mockMvc.perform(get("/odontologos/matricula/12345")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"nombre\":\"Juan\",\"apellido\":\"Pérez\",\"matricula\":\"12345\"}"));
    }
}
