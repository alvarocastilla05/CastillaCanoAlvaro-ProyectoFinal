import customParseFormat from "dayjs/plugin/customParseFormat";
dayjs.extend(customParseFormat);

 function validarFormulario() {
            // Obtener referencias a los campos del formulario
            let nombre = document.getElementById('nombre');
            let ciudad = document.getElementById('ciudad');
            let fecha = document.getElementById('fecha');
            let hora = document.getElementById('hora');
            let duracion = document.getElementById('duracion');
            let kmARecorrer = document.getElementById('kmARecorrer');
            let respuesta = document.querySelector('input[name="respuesta"]:checked');
            let musicosNecesarios = document.getElementById('musicosNecesarios');
            let dineroPagado = document.getElementById('dineroPagado');
            let aforo = document.getElementById('aforo');
            let gratuitoSi = document.getElementById('gratuitoSi');
            let gratuitoNo = document.getElementById('gratuitoNo');
            let img = document.getElementById('img');

            // Verificar que todos los campos obligatorios estén completos
            if (nombre.value === "" || ciudad.value === "" || fecha.value === "" || hora.value === "" || duracion.value === "" || kmARecorrer.value === "" || respuesta === null || musicosNecesarios.value === "" || dineroPagado.value === "" || aforo.value === "" || (gratuitoSi.checked === false && gratuitoNo.checked === false) || img.value === "") {
                alert("Por favor, complete todos los campos obligatorios.");
                return false; // Evitar que se envíe el formulario
            }
        }


let ojo = document.getElementById('verPwd');

ojo.addEventListener('pointerover', mostrarContrasena);
ojo.addEventListener('pointerout', ocultarContrasena);

function mostrarContrasena(evento){
    this.previousElementSibling.type = 'text';
}

function ocultarContrasena(evento){
    this.previousElementSibling.type = 'password';
}


document.addEventListener('DOMContentLoaded', function() {
    let busSi = document.getElementById('si');
    let busNo = document.getElementById('no');
    let divBus = document.querySelector('.d-none');

    function busInput() {
        divBus.classList.toggle('d-none', busNo.checked);
    }

    busSi.addEventListener('change', busInput);
    busNo.addEventListener('change', busInput);

    busInput();
});


document.addEventListener('DOMContentLoaded', function() {
    let gratuitoSi = document.getElementById('gratuitoSi');
    let gratuitoNo = document.getElementById('gratuitoNo');
    let divPrecio = document.getElementById('precio');

    function precioInput() {
        divPrecio.classList.toggle('d-none', gratuitoSi.checked);
    }

    gratuitoSi.addEventListener('change', precioInput);
    gratuitoNo.addEventListener('change', precioInput);

    precioInput(); 
});

function confirmarEliminacionMusico(id) {
    if (confirm('¿Estás seguro de que quieres eliminar este músico?')) {
        window.location.href = '/admin/musico/eliminar/' + id;
    }
}

function confirmarEliminacionConcierto(id) {
    if (confirm('¿Estás seguro de que quieres eliminar esta concierto?')) {
        window.location.href = '/admin/evento/eliminar/concierto/' + id;
    }
}

function confirmarEliminacionProcesion(id) {
    if (confirm('¿Estás seguro de que quieres eliminar esta procesion?')) {
        window.location.href = '/admin/evento/eliminar/procesion/' + id;
    }
}

function confirmarEliminacionBus(id) {
    if (confirm('¿Estás seguro de que quieres eliminar este autobús?')) {
        window.location.href = '/admin/bus/eliminar/' + id;
    }
}

function limpiarCampos(){
	window.location.href = '/admin/musico/listado';
}






