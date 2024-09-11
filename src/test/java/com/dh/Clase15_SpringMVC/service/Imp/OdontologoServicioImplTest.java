package com.dh.Clase15_SpringMVC.service.Imp;

import com.dh.Clase15_SpringMVC.entity.Odontologo;
import com.dh.Clase15_SpringMVC.exception.ResourceNotFoundException;
import com.dh.Clase15_SpringMVC.repository.IOdontologoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
public class OdontologoServicioImplTest {
    @Autowired
    private OdontologoServicioImpl odontologoServicio;
    @Autowired
    private IOdontologoRepository iOdontologoRepository;
    private Odontologo odontologo;
    // solo para resaltar los mensajes en la consola
    String azulElectricoNegrita = "\u001B[96m\u001B[1m";
    String reset = "\u001B[0m";
    @BeforeEach
    void configuracionParaTest() {
        odontologo = new Odontologo();
        odontologo.setNombre("juan");
        odontologo.setApellido("perez");
        odontologo.setMatricula("1234");
    }

    @Test
    public void casoGuardarOdontologo() {
        Odontologo resultado = odontologoServicio.guardar(odontologo);

        assertNotNull(resultado);
        assertEquals("juan", resultado.getNombre());
        assertEquals("perez", resultado.getApellido());
        assertEquals("1234", resultado.getMatricula());

        assertTrue(iOdontologoRepository.findById(resultado.getId()).isPresent());

        System.out.println(azulElectricoNegrita + "El test casoGuardarOdontologo pasó correctamente" + reset);
    }

    @Test
    public void casoBuscarOdontologoNoExistente() {
        Long idNoExistente = 999L;

        // assertThrows para verificar que se lanza la excepción esperada
        ResourceNotFoundException thrownException = assertThrows(
                ResourceNotFoundException.class,
                () -> odontologoServicio.buscarPorId(idNoExistente),
                "Se esperaba que se lanzara ResourceNotFoundException"
        );

        // verificacion del mensaje de la excepción
        assertEquals("No se encontro el Odontologo con id: 999", thrownException.getMessage());

        System.out.println(azulElectricoNegrita + "El test de casoBuscarOdontologoNoExistente ha fallado como se esperaba (no se encontró al Odontologo)" + reset);
    }

    @Test
    public void casoActualizarOdontologo() {
        Odontologo odontologoGuardado = odontologoServicio.guardar(odontologo);
        Long id = odontologoGuardado.getId();

        // actualizamos al Odontologo
        Odontologo odontologoActualizado = new Odontologo();
        odontologoActualizado.setNombre("juanito");
        odontologoActualizado.setApellido("perez");
        odontologoActualizado.setMatricula("1234");

        // actualizamos el odontólogo existente
        Odontologo resultado = odontologoServicio.actualizar(odontologoActualizado, id);

        // verificamos que la actualización fue exitosa
        assertNotNull(resultado);
        assertEquals("juanito", resultado.getNombre());
        assertEquals("perez", resultado.getApellido());
        assertEquals("1234", resultado.getMatricula());
        assertEquals(id, resultado.getId());

        System.out.println(azulElectricoNegrita + "El test de casoActualizarOdontologo pasó exitosamente" + reset);
    }

    @Test
    public void casoActualizarOdontologoNoExistente() {
        // creamos un odontólogo para actualizar con nuevos datos
        Odontologo odontologoActualizado = new Odontologo();
        odontologoActualizado.setNombre("juanito");
        odontologoActualizado.setApellido("perez");
        odontologoActualizado.setMatricula("1234");

        // con un id que no existe
        Long idNoExistente = 333L;

        // verificamos que se lanza la excepción esperada
        ResourceNotFoundException thrownException = assertThrows(
                ResourceNotFoundException.class,
                () -> odontologoServicio.actualizar(odontologoActualizado, idNoExistente)
        );

        assertEquals("No se encontro al Odontologo con id: " + idNoExistente + " para actualizarlo", thrownException.getMessage());

        System.out.println(azulElectricoNegrita + "El test de casoActualizarOdontologoNoExistente ha fallado como se esperaba (no se encontró al Odontologo)" + reset);
    }

    @Test
    public void casoEliminarOdontologo() {
        // guardamos el odontologo inicial
        Odontologo odontologoGuardado = odontologoServicio.guardar(odontologo);
        Long id = odontologoGuardado.getId();

        // eliminamos el odontologo
        odontologoServicio.eliminar(id);

        // verificamos que se lance una excepcion al buscar el odontologo eliminado
        ResourceNotFoundException thrownException = assertThrows(ResourceNotFoundException.class, () -> {
            odontologoServicio.buscarPorId(id);
        });

        // verificamos el mensaje de la excepcion
        assertEquals("No se encontro el Odontologo con id: " + id, thrownException.getMessage());

        System.out.println(azulElectricoNegrita + "El test casoEliminarOdontologo pasó exitosamente" + reset);
    }

    @Test
    public void casoEliminarOdontologoNoExistente() {
        // usamos un id que no existe
        Long idNoExistente = 987654321L;

        // verificamos que se lanza la excepcion esperada
        ResourceNotFoundException thrownException = assertThrows(
                ResourceNotFoundException.class,
                () -> odontologoServicio.eliminar(idNoExistente)
        );

        // verificamos el mensaje de la excepcion
        assertEquals("No se encontro al Odontologo con id: " + idNoExistente + " para eliminarlo", thrownException.getMessage());

        System.out.println(azulElectricoNegrita + "El test de casoEliminarOdontologoNoExistente ha fallado como se esperaba (no se encontró al Odontologo)" + reset);
    }

}
