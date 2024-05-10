


document.addEventListener('DOMContentLoaded', function() {
    var gratuitoSi = document.getElementById('si');
    var gratuitoNo = document.getElementById('no');
    var divPrecio = document.querySelector('.d-none');

    function togglePrecioInput() {
        divPrecio.classList.toggle('d-none', gratuitoNo.checked);
    }

    gratuitoSi.addEventListener('change', togglePrecioInput);
    gratuitoNo.addEventListener('change', togglePrecioInput);

    togglePrecioInput(); // Ejecutar al cargar la página para establecer el estado inicial
});


