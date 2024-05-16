insert into musico (id, nombre, apellidos, username, password, tipo_instrumento, fecha_alta, admin) values (1, 'Alvaro', 'Castilla Cano', 'alvarocastilla@amueci.es', '{bcrypt}$2y$10$ddfFumDiAoDhpNj0XYRVHe3CEazScrvDNLqU2X8VwXGCoS6HT4Dt6', 'Percusion', '2020-01-06', false);
insert into musico (id, nombre, apellidos, username, password, tipo_instrumento, fecha_alta, admin) values (2, 'Lucas', 'Falla Urtiaga', 'lucasfalla@amueci.es', '{bcrypt}$2y$10$JDTNn62jTwOCGp/AXERmc.gK2GNRoZtIeww1SNnDQzsEx4Acvtw8m', 'Percusion', '2019-05-01', false);
insert into musico (id, nombre, apellidos, username, password, tipo_instrumento, fecha_alta, admin) values (3, 'admin', 'admin', 'admin', '{bcrypt}$2y$10$Ra8hLpI7cMY21iuUhxI0e.SMoSgjtpABaEEdw9gVu2R1MuLLweFbe', null, '2019-05-01', true);

ALTER SEQUENCE musico_seq RESTART WITH 53;

insert into bus(id, nombre, plazas, precio_km, descuento) values (1, 'Autobús 50 Plazas', 50, 2, 0);
insert into bus(id, nombre, plazas, precio_km, descuento) values (2, 'Autobús 65 Plazas', 65, 2.5, 0);
insert into bus(id, nombre, plazas, precio_km, descuento) values (3, 'Autobús 80 Plazas', 80, 3, 0);
insert into bus(id, nombre, plazas, precio_km, descuento) values (4, 'Autobús 100 Plazas', 100, 3.25, 0);

ALTER SEQUENCE bus_seq RESTART WITH 54;

insert into evento(id, nombre, fecha, hora, duracion, ciudad, kmarecorrer, musicos_necesarios, bus_contratado, dinero_pagado, url_img, bus_id) values (1, 'Concierto Santa Cecilia', '2023-11-18', '18:00', 2, 'Ecija', 0, 65, false, 1000, 'https://pbs.twimg.com/media/F-RPbXyXEAANeVz?format=jpg&name=large', null);
insert into concierto(id, aforo, gratuito, precio) values (1, 100, true, 0);

insert into evento(id, nombre, fecha, hora, duracion, ciudad, kmarecorrer, musicos_necesarios, bus_contratado, dinero_pagado, url_img, bus_id) values (3, 'Concierto Santo Angel', '2024-02-24', '21:15', 2, 'Sevilla', 86.3, 65, true, 3000, 'https://amueci.com/wp-content/uploads/2024/02/cartel1-819x1024.jpg', 2);
insert into concierto(id, aforo, gratuito, precio) values (3, 200, true, 0);

insert into evento(id, nombre, fecha, hora, duracion, ciudad, kmarecorrer, musicos_necesarios, bus_contratado, dinero_pagado, url_img, bus_id) values (4, 'Concierto Marchas Procesionales Huelva', '2025-03-11', '21:00', 2, 'Huelva', 180, 65, true, 2500, 'https://www.artesacro.org/imagenes/IMG-20230309-WA0001.jpg', 2);
insert into concierto(id, aforo, gratuito, precio) values (4, 150, true, 0);

insert into evento(id, nombre, fecha, hora, duracion, ciudad, kmarecorrer, musicos_necesarios, bus_contratado, dinero_pagado, url_img, bus_id) values (5, 'Concierto Santa Cecilia', '2024-11-06', '12:30', 2, 'Ecija', 0, 65, false, 1000, 'https://pbs.twimg.com/media/F-RPbXyXEAANeVz?format=jpg&name=large', null);
insert into concierto(id, aforo, gratuito, precio) values (5, 100, true, 0);

insert into evento(id, nombre, fecha, hora, duracion, ciudad, kmarecorrer, musicos_necesarios, bus_contratado, dinero_pagado, url_img, bus_id) values (6, 'Concierto Santa Cecilia', '2024-11-06', '12:30', 2, 'Ecija', 0, 65, false, 1000, 'https://pbs.twimg.com/media/F-RPbXyXEAANeVz?format=jpg&name=large', null);
insert into concierto(id, aforo, gratuito, precio) values (6, 100, true, 0);

insert into evento(id, nombre, fecha, hora, duracion, ciudad, kmarecorrer, musicos_necesarios, bus_contratado, dinero_pagado, url_img, bus_id) values (7, 'Concierto Santa Cecilia', '2024-11-06', '12:30', 2, 'Ecija', 0, 65, false, 1000, 'https://pbs.twimg.com/media/F-RPbXyXEAANeVz?format=jpg&name=large', null);
insert into concierto(id, aforo, gratuito, precio) values (7, 100, true, 0);


insert into evento(id, nombre, fecha, hora, duracion, ciudad, kmarecorrer, musicos_necesarios, bus_contratado, dinero_pagado, url_img, bus_id) values (2, 'Procesion Cena Huelva', '2024-04-06', '12:30', 8, 'Huelva', 200, 80, true, 10000, 'https://pbs.twimg.com/media/GJbGW2qXoAAXBKZ.jpg', 3);
insert into procesion(id, hermandad, titular, precio_horas_extras) values (2, 'Cena Huelva', 'Rosario del Polvorin', 100);

ALTER SEQUENCE evento_seq RESTART WITH 57;