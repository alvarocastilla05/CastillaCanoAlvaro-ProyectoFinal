insert into musico (id, nombre, apellidos, username, password, tipo_instrumento, fecha_alta, admin) values (1, 'Alvaro', 'Castilla Cano', 'alvarocastilla@amueci.es', '{noop}12345', 'Percusion', '2020-01-06', false);
insert into musico (id, nombre, apellidos, username, password, tipo_instrumento, fecha_alta, admin) values (2, 'Lucas', 'Falla Urtiaga', 'lucasfalla@amueci.es', '{noop}54123', 'Percusion', '2019-05-01', false);
insert into musico (id, nombre, apellidos, username, password, tipo_instrumento, fecha_alta, admin) values (3, 'admin', 'admin', 'admin', '{noop}admin', null, '2019-05-01', true);

ALTER SEQUENCE musico_seq RESTART WITH 53;

insert into bus(id, nombre, plazas, precio_km, descuento) values (1, 'Autobús 50 Plazas', 50, 2, 0);
insert into bus(id, nombre, plazas, precio_km, descuento) values (2, 'Autobús 65 Plazas', 65, 2.5, 0);
insert into bus(id, nombre, plazas, precio_km, descuento) values (3, 'Autobús 80 Plazas', 80, 3, 0);
insert into bus(id, nombre, plazas, precio_km, descuento) values (4, 'Autobús 100 Plazas', 100, 3.25, 0);

ALTER SEQUENCE bus_seq RESTART WITH 54;

insert into evento(id, nombre, fecha, hora, duracion, ciudad, kmarecorrer, musicos_necesarios, bus_contratado, dinero_pagado, url_img, bus_id) values (1, 'Concierto Santa Cecilia', '2024-11-06', '12:30', 2, 'Ecija', 0, 65, false, 1000, 'https://pbs.twimg.com/media/F-RPbXyXEAANeVz?format=jpg&name=large', null);
insert into concierto(id, aforo, gratuito, precio) values (1, 100, true, 0);


insert into evento(id, nombre, fecha, hora, duracion, ciudad, kmarecorrer, musicos_necesarios, bus_contratado, dinero_pagado, url_img, bus_id) values (2, 'Procesion Cena Huelva', '2024-04-06', '12:30', 8, 'Huelva', 200, 80, true, 10000, 'https://pbs.twimg.com/media/GJbGW2qXoAAXBKZ.jpg', 3);
insert into procesion(id, hermandad, titular, precio_horas_extras) values (2, 'Cena Huelva', 'Rosario del Polvorin', 100);

ALTER SEQUENCE evento_seq RESTART WITH 52;