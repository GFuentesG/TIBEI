// js/paciente_tabs.js

// Función para abrir una pestaña específica y ocultar las otras
function openTab(evt, tabName) {
    // Obtener todas las pestañas
    var i, tabcontent, tablinks;

    // Ocultar todas las pestañas
    tabcontent = document.getElementsByClassName("tab-content");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Remover la clase activa de todos los botones
    tablinks = document.getElementsByClassName("tab-button");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Mostrar la pestaña actual y añadir la clase activa
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Mostrar la primera pestaña (Listado) por defecto
document.addEventListener("DOMContentLoaded", function() {
    document.getElementsByClassName("tab-button")[1].click(); // Activar la pestaña Listado al cargar la página
});
