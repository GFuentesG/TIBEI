window.addEventListener('load', function () {
    const formulario = document.querySelector('#update_turno_form');

    formulario.addEventListener('submit', function (event) {
        event.preventDefault();

        let turnoId = document.querySelector('#turno_id').value;

        const formData = {
            id: turnoId,
            odontologoId: document.querySelector('#odontologo_id').value,
            pacienteId: document.querySelector('#paciente_id').value,
            fecha: document.querySelector('#fecha').value,
            hora: document.querySelector('#hora').value
        };

        const url = '/turnos/' + turnoId;
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                alert('Turno actualizado exitosamente');
                resetForm();
            })
            .catch(error => {
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
