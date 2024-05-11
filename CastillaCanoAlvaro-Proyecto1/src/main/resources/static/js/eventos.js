


document.addEventListener('DOMContentLoaded', function() {
    let gratuitoSi = document.getElementById('si');
    let gratuitoNo = document.getElementById('no');
    let divPrecio = document.querySelector('.d-none');

    function precioInput() {
        divPrecio.classList.toggle('d-none', gratuitoSi.checked);
    }

    gratuitoSi.addEventListener('change', precioInput);
    gratuitoNo.addEventListener('change', precioInput);

    precioInput(); // Ejecutar al cargar la página para establecer el estado inicial
});


