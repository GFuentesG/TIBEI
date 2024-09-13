window.addEventListener('load', function () {
    const formulario = document.querySelector('#add_new_turno');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        // Datos del nuevo turno a guardar
        const formData = {
            odontologo: {
                id: document.querySelector('#odontologo').value
            },
            paciente: {
                id: document.querySelector('#paciente').value
            },
            fecha: document.querySelector('#fecha').value,
            hora: document.querySelector('#hora').value
        };

        // Invocamos utilizando fetch la API de turnos con el método POST
        const url = '/turnos';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                let successAlert = '<div class="alert alert-success alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Turno agregado exitosamente</strong></div>';

                document.querySelector('#response').innerHTML = successAlert;
                document.querySelector('#response').style.display = "block";
                resetForm();
            })
            .catch(error => {
                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                    '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                    '<strong>Error al agregar el turno. Intente nuevamente.</strong></div>';

                document.querySelector('#response').innerHTML = errorAlert;
                document.querySelector('#response').style.display = "block";
                resetForm();
            });
    });

    function resetForm() {
        document.querySelector('#odontologo').value = "";
        document.querySelector('#paciente').value = "";
        document.querySelector('#fecha').value = "";
        document.querySelector('#hora').value = "";
    }

    // Función para cargar odontólogos y pacientes
    function loadOptions() {
        fetch('/odontologos')
            .then(response => response.json())
            .then(data => {
                const odontologoSelect = document.querySelector('#odontologo');
                data.forEach(odontologo => {
                    const option = document.createElement('option');
                    option.value = odontologo.id;
                    option.textContent = odontologo.nombre;
                    odontologoSelect.appendChild(option);
                });
            })
            .catch(error => console.error('Error al cargar odontólogos:', error));

        fetch('/pacientes')
            .then(response => response.json())
            .then(data => {
                const pacienteSelect = document.querySelector('#paciente');
                data.forEach(paciente => {
                    const option = document.createElement('option');
                    option.value = paciente.id;
                    option.textContent = paciente.nombre;
                    pacienteSelect.appendChild(option);
                });
            })
            .catch(error => console.error('Error al cargar pacientes:', error));
    }

    // Cargar las opciones al cargar la página
    loadOptions();
});
