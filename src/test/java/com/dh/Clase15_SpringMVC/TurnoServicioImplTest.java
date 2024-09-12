import com.dh.Clase15_SpringMVC.entity.Odontologo;
import com.dh.Clase15_SpringMVC.exception.BadRequestException;
import com.dh.Clase15_SpringMVC.repository.IOdontologoRepository;
import com.dh.Clase15_SpringMVC.repository.ITurnoRepository;
import com.dh.Clase15_SpringMVC.service.Imp.TurnoServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class TurnoServicioImplTest {

    @Mock
    private IOdontologoRepository odontologoRepository;

    @Mock
    private ITurnoRepository turnoRepository;

    @InjectMocks
    private TurnoServicioImpl turnoServicio;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testBuscarOdontologosDisponibles_NoOdontologos_ShouldThrowBadRequestException() {
        // Configuración: Sin odontólogos disponibles
        when(odontologoRepository.findAll()).thenReturn(Collections.emptyList());

        LocalDate fecha = LocalDate.now();
        LocalTime hora = LocalTime.now();

        // Verificación
        assertThrows(BadRequestException.class, () -> {
            turnoServicio.buscarOdontologosDisponibles(fecha, hora);
        });
    }

    // Agregar más pruebas aquí
}

