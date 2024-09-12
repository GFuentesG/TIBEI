function findBy(id) {
    fetch(`/odontologos/${id}`)
    .then(response => response.json())
    .then(data => {
        if (data) {
            document.querySelector('#odontologo-info').style.display = 'block';
            document.querySelector('#nombre-actualizar').value = data.nombre;
            document.querySelector('#apellido-actualizar').value = data.apellido;
            document.querySelector('#matricula-actualizar').value = data.matricula;
            document.querySelector('#odontologo_id-actualizar').value = data.id;
        } else {
            alert('Odontólogo no encontrado');
        }
    })
    .catch(error => console.error('Error al buscar odontólogo:', error));
}

document.querySelector('#form-actualizar').addEventListener('submit', function (event) {
    event.preventDefault();

    const id = document.querySelector('#odontologo_id-actualizar').value;
    const odontologo = {
        nombre: document.querySelector('#nombre-actualizar').value,
        apellido: document.querySelector('#apellido-actualizar').value,
        matricula: document.querySelector('#matricula-actualizar').value
    };

    fetch(`/odontologos/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(odontologo)
    })
    .then(response => {
        if (response.ok) {
            alert('Odontólogo actualizado con éxito');
            location.reload();  // Recargar la página para reflejar los cambios
        } else {
            alert('Error al actualizar el odontólogo');
        }
    })
    .catch(error => console.error('Error al actualizar odontólogo:', error));
});
