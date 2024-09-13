window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_turno_form');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        let turnoId = document.querySelector('#turno_id').value;

        const formData = {
            id: turnoId,
            odontologo: {
                id: document.querySelector('#odontologo_id').value
            },
            paciente: {
                id: document.querySelector('#paciente_id').value
            },
            fecha: document.querySelector('#fecha').value,
            hora: document.querySelector('#hora').value
        };

        console.log('Datos a enviar:', formData); // Agregado para depuración

        const url = '/turnos/' + turnoId;
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        };

        fetch(url, settings)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                alert('Turno actualizado exitosamente');
                resetForm();
            })
            .catch(error => {
                console.error('Error al actualizar el turno:', error);
                alert('Error al actualizar el turno: ' + error);
            });
    });

    function resetForm() {
        document.querySelector('#turno_id').value = "";
        document.querySelector('#odontologo_id').value = "";
        document.querySelector('#paciente_id').value = "";
        document.querySelector('#fecha').value = "";
        document.querySelector('#hora').value = "";
        document.querySelector('#div_turno_updating').style.display = "none";
    }
});
