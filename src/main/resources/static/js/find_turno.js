window.findBy = function(id) {
    const urlTurno = '/turnos/' + id;
    const settings = {
        method: 'GET'
    };

    // Obtener el turno
    fetch(urlTurno, settings)
        .then(response => response.json())
        .then(turno => {
            document.querySelector('#turno_id').value = turno.id;
            document.querySelector('#odontologo_id').value = turno.odontologo.id;
            document.querySelector('#paciente_id').value = turno.paciente.id;
            document.querySelector('#fecha').value = turno.fecha;
            document.querySelector('#hora').value = turno.hora;
            document.querySelector('#div_turno_updating').style.display = "block";

            // Llenar los campos de odontólogo y paciente
            loadOdontologos();
            loadPacientes();
        })
        .catch(error => {
            alert('Error al cargar el turno: ' + error);
        });
};

function loadOdontologos() {
    const url = '/odontologos';  // Ajusta esta URL según tu API
    fetch(url)
        .then(response => response.json())
        .then(data => {
            const odontologoSelect = document.querySelector('#odontologo_id');
            odontologoSelect.innerHTML = '';  // Limpiar opciones existentes

            data.forEach(odontologo => {
                const option = document.createElement('option');
                option.value = odontologo.id;
                option.textContent = `${odontologo.nombre} ${odontologo.apellido}`;
                odontologoSelect.appendChild(option);
            });
        })
        .catch(error => {
            alert('Error al cargar odontólogos: ' + error);
        });
}

function loadPacientes() {
    const url = '/pacientes';  // Ajusta esta URL según tu API
    fetch(url)
        .then(response => response.json())
        .then(data => {
            const pacienteSelect = document.querySelector('#paciente_id');
            pacienteSelect.innerHTML = '';  // Limpiar opciones existentes

            data.forEach(paciente => {
                const option = document.createElement('option');
                option.value = paciente.id;
                option.textContent = `${paciente.nombre} ${paciente.apellido}`;
                pacienteSelect.appendChild(option);
            });
        })
        .catch(error => {
            alert('Error al cargar pacientes: ' + error);
        });
}
