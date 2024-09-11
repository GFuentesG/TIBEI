document.addEventListener('DOMContentLoaded', function () {
    // Referencias a los formularios y elementos del DOM
    const buscarDisponiblesForm = document.getElementById('buscar-disponibles-form');
    const buscarDisponibilidadOdontologoForm = document.getElementById('buscar-disponibilidad-odontologo-form');
    const turnoForm = document.getElementById('turno-form');
    const odontologosDisponiblesList = document.getElementById('odontologos-disponibles');
    const disponibilidadOdontologoList = document.getElementById('disponibilidad-odontologo');

    // Función para listar odontólogos disponibles por fecha y hora
    buscarDisponiblesForm.addEventListener('submit', function (event) {
        event.preventDefault();
        const fecha = document.getElementById('fecha-disponible').value;
        const hora = document.getElementById('hora-disponible').value;

        fetch(`http://localhost:8081/turnos/disponibles?fecha=${fecha}&hora=${hora}`)
            .then(response => response.json())
            .then(data => {
                odontologosDisponiblesList.innerHTML = '';
                if (data.length === 0) {
                    odontologosDisponiblesList.innerHTML = '<li>No hay odontólogos disponibles para esta fecha y hora</li>';
                } else {
                    data.forEach(odontologo => {
                        const li = document.createElement('li');
                        li.textContent = `Odontólogo: ${odontologo.nombre}, Matrícula: ${odontologo.matricula}`;
                        odontologosDisponiblesList.appendChild(li);
                    });
                }
            })
            .catch(error => {
                console.error('Error al buscar odontólogos disponibles:', error);
            });
    });

    // Función para buscar la disponibilidad de un odontólogo por nombre
    buscarDisponibilidadOdontologoForm.addEventListener('submit', function (event) {
        event.preventDefault();
        const odontologoNombre = document.getElementById('odontologo-nombre-disponibilidad').value;

        fetch(`http://localhost:8081/turnos/disponibilidad?odontologoNombre=${odontologoNombre}`)
            .then(response => response.json())
            .then(data => {
                disponibilidadOdontologoList.innerHTML = '';
                if (data.length === 0) {
                    disponibilidadOdontologoList.innerHTML = '<li>No hay turnos disponibles para este odontólogo</li>';
                } else {
                    data.forEach(turno => {
                        const li = document.createElement('li');
                        li.textContent = `Fecha: ${turno.fecha}, Hora: ${turno.hora}`;
                        disponibilidadOdontologoList.appendChild(li);
                    });
                }
            })
            .catch(error => {
                console.error('Error al buscar disponibilidad del odontólogo:', error);
            });
    });

    // Función para registrar un turno
    turnoForm.addEventListener('submit', function (event) {
        event.preventDefault();
        const odontologoNombre = document.getElementById('odontologo-nombre').value;
        const pacienteNombre = document.getElementById('paciente-nombre').value;
        const fecha = document.getElementById('fecha-turno').value;
        const hora = document.getElementById('hora-turno').value;

        const turno = {
            odontologoNombre: odontologoNombre,
            pacienteNombre: pacienteNombre,
            fecha: fecha,
            hora: hora
        };

        fetch('http://localhost:8081/turnos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(turno)
        })
        .then(response => response.json())
        .then(data => {
            alert('Turno registrado correctamente');
        })
        .catch(error => {
            console.error('Error al registrar el turno:', error);
        });
    });
});
