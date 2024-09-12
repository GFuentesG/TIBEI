document.querySelector('#form-alta-turno').addEventListener('submit', function (event) {
    event.preventDefault();

    const odontologoNombre = document.getElementById('odontologo-alta').value;
    const pacienteNombre = document.getElementById('paciente-alta').value;
    const fecha = document.getElementById('fecha-alta').value;
    const hora = document.getElementById('hora-alta').value;

    const data = {
        odontologoNombre,
        pacienteNombre,
        fecha,
        hora
    };
 const data = {
        pacienteId,
        odontologoId,
        fecha,
        hora
    };

    fetch('/turnos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        alert('Turno registrado con éxito!');
        document.getElementById('form-alta-turno').reset();  // Limpiar el formulario
    })
    .catch(error => {
        console.error('Error al registrar el turno:', error);
        alert('Hubo un error al registrar el turno. Inténtalo de nuevo.');
    });
});
