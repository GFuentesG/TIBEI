window.addEventListener('load', function () {
    const buscarBtn = document.getElementById("buscar_paciente_btn");

    buscarBtn.addEventListener('click', function () {
        const dni = document.getElementById("dni").value;
        const url = '/pacientes/dni/' + dni;
        const settings = {
            method: 'GET'
        };

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                // Mostrar resultado
                document.getElementById("paciente_resultado").style.display = "block";
                let tableBody = document.getElementById("pacienteTableBody");
                tableBody.innerHTML = ''; // Limpiar resultados anteriores

                let row = document.createElement('tr');
                row.innerHTML = `<td>${data.id}</td>
                                 <td>${data.nombre}</td>
                                 <td>${data.apellido}</td>
                                 <td>${data.dni}</td>`;
                tableBody.appendChild(row);
            })
            .catch(error => {
                alert("No se encontró el paciente con dni " + dni);
            });
    });
});
