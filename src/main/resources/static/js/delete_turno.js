function deleteBy(id) {
    // Invocamos la API de turnos con el método DELETE
    const url = '/turnos/' + id;
    const settings = {
        method: 'DELETE'
    };

    fetch(url, settings)
        .then(response => {
            if (response.ok) {
                // Eliminar la fila del turno eliminado
                let row_id = "#tr_" + id;
                document.querySelector(row_id).remove();
            } else {
                alert('Error al eliminar el turno');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
