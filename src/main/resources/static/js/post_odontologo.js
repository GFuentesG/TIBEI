document.querySelector('#form-alta').addEventListener('submit', function (event) {
    event.preventDefault();

    const odontologo = {
        nombre: document.querySelector('#nombre-alta').value,
        apellido: document.querySelector('#apellido-alta').value,
        matricula: document.querySelector('#matricula-alta').value
    };

    fetch('/odontologos', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(odontologo)
    })
    .then(response => {
        if (response.ok) {
            alert('Odontólogo registrado con éxito');
            location.reload();  // Recargar la página para mostrar el nuevo odontólogo
        } else {
            alert('Error al registrar el odontólogo');
        }
    })
    .catch(error => console.error('Error al registrar odontólogo:', error));
});
