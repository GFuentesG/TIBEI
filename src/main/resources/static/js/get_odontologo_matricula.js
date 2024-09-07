window.addEventListener('load', function () {
    const buscarBtn = document.getElementById("buscar_odontologo_btn");

    buscarBtn.addEventListener('click', function () {
        const matricula = document.getElementById("matricula").value;
        const url = '/odontologos/matricula/' + matricula;
        const settings = {
            method: 'GET'
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                // Mostrar resultado
                document.getElementById("odontologo_resultado").style.display = "block";
                let tableBody = document.getElementById("odontologoTableBody");
                tableBody.innerHTML = ''; // Limpiar resultados anteriores

                let row = document.createElement('tr');
                row.innerHTML = `<td>${data.id}</td>
                                 <td>${data.nombre}</td>
                                 <td>${data.apellido}</td>
                                 <td>${data.matricula}</td>`;
                tableBody.appendChild(row);
            })
            .catch(error => {
                alert("No se encontró el odontólogo con matrícula " + matricula);
            });
    });
});
