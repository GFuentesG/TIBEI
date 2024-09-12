// Al cargar la página, buscamos los odontólogos y pacientes disponibles
window.addEventListener('load', function () {
    cargarOdontologos();
    cargarPacientes();

    // Manejador del formulario de creación de turno
    document.getElementById('turno-form').addEventListener('submit', function (event) {
        event.preventDefault();

        const turnoData = {
            odontologoId: document.getElementById('odontologo').value,
            pacienteId: document.getElementById('paciente').value,
            fecha: document.getElementById('fecha').value,
            hora: document.getElementById('hora').value
        };

        fetch('/turnos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(turnoData)
        })
        .then(response => response.json())
        .then(data => {
            alert('Turno guardado con éxito');
            cargarTurnos();  // Recargar la lista de turnos después de agregar uno
        })
        .catch(error => {
            console.error('Error al guardar el turno:', error);
        });
    });
});

// Función para cargar odontólogos
function cargarOdontologos() {
    fetch('/odontologos')
        .then(response => response.json())
        .then(data => {
            const odontologoSelect = document.getElementById('odontologo');
            odontologoSelect.innerHTML = '';  // Limpiar select
            data.forEach(odontologo => {
                const option = document.createElement('option');
                option.value = odontologo.id;
                option.textContent = odontologo.nombre + ' ' + odontologo.apellido;
                odontologoSelect.appendChild(option);
            });
        })
        .catch(error => console.error('Error al cargar odontólogos:', error));
}

// Función para cargar pacientes
function cargarPacientes() {
    fetch('/pacientes')
        .then(response => response.json())
        .then(data => {
            const pacienteSelect = document.getElementById('paciente');
            pacienteSelect.innerHTML = '';  // Limpiar select
            data.forEach(paciente => {
                const option = document.createElement('option');
                option.value = paciente.id;
                option.textContent = paciente.nombre + ' ' + paciente.apellido;
                pacienteSelect.appendChild(option);
            });
        })
        .catch(error => console.error('Error al cargar pacientes:', error));
}

// Función para cargar turnos
function cargarTurnos() {
    fetch('/turnos')
        .then(response => response.json())
        .then(data => {
            const turnosList = document.getElementById('turnos-list');
            turnosList.innerHTML = '';  // Limpiar tabla
            data.forEach(turno => {
                const row = document.createElement('tr');
                row.innerHTML = `
                    <td>${turno.odontologo.nombre} ${turno.odontologo.apellido}</td>
                    <td>${turno.paciente.nombre} ${turno.paciente.apellido}</td>
                    <td>${turno.fecha}</td>
                    <td>${turno.hora}</td>
                    <td>
                        <button class="btn btn-warning btn-sm" onclick="editarTurno(${turno.id})">Editar</button>
                        <button class="btn btn-danger btn-sm" onclick="eliminarTurno(${turno.id})">Eliminar</button>
                    </td>
                `;
                turnosList.appendChild(row);
            });
        })
        .catch(error => console.error('Error al cargar turnos:', error));
}

// Función para editar un turno
function editarTurno(id) {
    // Lógica para editar el turno
}

// Función para eliminar un turno
function eliminarTurno(id) {
    fetch(`/turnos/${id}`, { method: 'DELETE' })
        .then(response => {
            alert('Turno eliminado con éxito');
            cargarTurnos();  // Recargar la lista de turnos
        })
        .catch(error => console.error('Error al eliminar el turno:', error));
}

