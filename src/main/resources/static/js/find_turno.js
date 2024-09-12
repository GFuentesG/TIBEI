function findBy(id) {
    const url = '/turnos/' + id;
    const settings = {
        method: 'GET'
    };

    fetch(url, settings)
        .then(response => response.json())
        .then(data => {
            let turno = data;
            document.querySelector('#turno_id').value = turno.id;
            document.querySelector('#odontologo_id').value = turno.odontologo.id;
            document.querySelector('#paciente_id').value = turno.paciente.id;
            document.querySelector('#fecha').value = turno.fecha;
            document.querySelector('#hora').value = turno.hora;
            document.querySelector('#div_turno_updating').style.display = "block";
        })
        .catch(error => {
            alert('Error al cargar el turno: ' + error);
        });
}
