insert into musico (id, nombre, apellidos, usuario, contrasenia, tipo_instrumento, fecha_alta) values (1, 'Alvaro', 'Castilla Cano', 'alvarocastilla@amueci.es', '12345', 'Percusion', '2020-01-06');
insert into musico (id, nombre, apellidos, usuario, contrasenia, tipo_instrumento, fecha_alta) values (2, 'Lucas', 'Falla Urtiaga', 'lucasfalla@amueci.es', '54123', 'Percusion', '2019-05-01');

ALTER SEQUENCE musico_seq RESTART WITH 52;

insert into bus(id, nombre, plazas, precio_km, descuento) values (1, 'Autobús 50 Plazas', 50, 2, 0);
insert into bus(id, nombre, plazas, precio_km, descuento) values (2, 'Autobús 65 Plazas', 65, 2.5, 0);
insert into bus(id, nombre, plazas, precio_km, descuento) values (3, 'Autobús 80 Plazas', 80, 3, 0);
insert into bus(id, nombre, plazas, precio_km, descuento) values (4, 'Autobús 100 Plazas', 100, 3.25, 0);

ALTER SEQUENCE bus_seq RESTART WITH 54;