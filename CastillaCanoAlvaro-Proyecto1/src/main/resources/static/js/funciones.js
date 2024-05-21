let ojo = document.getElementById('verPwd');

ojo.addEventListener('pointerover', mostrarContrasena);
ojo.addEventListener('pointerout', ocultarContrasena);

function mostrarContrasena(evento){
    this.previousElementSibling.type = 'text';
}

function ocultarContrasena(evento){
    this.previousElementSibling.type = 'password';
}