
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





