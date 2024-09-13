window.addEventListener('load', function () {
    (function() {
        // Invocamos a la API de turnos con el método GET para listar todos los turnos
        const url = '/turnos';
        const settings = {
            method: 'GET'
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                console.log('Datos recibidos:', data); // Para depuración
                const tableBody = document.getElementById("turnoTableBody");
                tableBody.innerHTML = ''; // Limpiar tabla antes de agregar nuevos datos

                for (let turno of data) {
                    var turnoRow = tableBody.insertRow();
                    let tr_id = 'tr_' + turno.id;
                    turnoRow.id = tr_id;

                    let deleteButton = '<button' +
                        ' id="btn_delete_' + turno.id + '"' +
                        ' type="button" onclick="deleteBy(' + turno.id + ')" class="btn btn-danger btn_delete">' +
                        '&times;' +
                        '</button>';

                    let updateButton = '<button' +
                        ' id="btn_id_' + turno.id + '"' +
                        ' type="button" onclick="findBy(' + turno.id + ')" class="btn btn-info btn_id">' +
                        turno.id +
                        '</button>';

                    let odontologoNombre = turno.odontologo ? turno.odontologo.nombre.toUpperCase() + ' ' + turno.odontologo.apellido.toUpperCase() : 'No Disponible';
                    let pacienteNombre = turno.paciente ? turno.paciente.nombre.toUpperCase() + ' ' + turno.paciente.apellido.toUpperCase() : 'No Disponible';

                    turnoRow.innerHTML = '<td>' + updateButton + '</td>' +
                        '<td class="td_odontologo">' + odontologoNombre + '</td>' +
                        '<td class="td_paciente">' + pacienteNombre + '</td>' +
                        '<td class="td_fecha">' + turno.fecha + '</td>' +
                        '<td class="td_hora">' + turno.hora + '</td>' +
                        '<td>' + deleteButton + '</td>';

                }
            })
            .catch(error => {
                console.error('Error al cargar los turnos:', error);
            });
    })();
});
