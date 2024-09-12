// js/turnos_tabs.js

// Función para abrir una pestaña específica y ocultar las otras
function openTab(evt, tabName) {
    // Obtener todas las pestañas (contenido de las pestañas)
    var i, tabcontent, tablinks;

    // Ocultar todo el contenido de las pestañas
    tabcontent = document.getElementsByClassName("tab-content");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Remover la clase "active" de todos los botones de pestañas
    tablinks = document.getElementsByClassName("tab-button");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Mostrar la pestaña actual y agregar la clase "active" al botón que fue clicado
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Mostrar la primera pestaña por defecto (Listado de Turnos)
document.addEventListener("DOMContentLoaded", function() {
    document.getElementsByClassName("tab-button")[1].click(); // Abrir la pestaña de Listado de Turnos al cargar la página
});
