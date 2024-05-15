
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





