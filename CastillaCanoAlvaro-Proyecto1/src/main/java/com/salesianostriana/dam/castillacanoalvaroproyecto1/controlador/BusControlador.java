package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.BusServicio;

@Controller
@RequestMapping("/admin/bus")
public class BusControlador {

	@Autowired
	private BusServicio busServicio;
}
