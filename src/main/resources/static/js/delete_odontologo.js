function deleteBy(id) {
    if (confirm('¿Estás seguro de que deseas eliminar este odontólogo?')) {
        fetch(`/odontologos/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                alert('Odontólogo eliminado con éxito');
                location.reload();  // Recargar la página para actualizar el listado
            } else {
                alert('Error al eliminar el odontólogo');
            }
        })
        .catch(error => console.error('Error al eliminar odontólogo:', error));
    }
}
