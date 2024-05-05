package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControlador {

	@GetMapping("/")
	public String index() {
		return "index";//Mostramos la plantilla index
	}
	
	@GetMapping("/escuela")
	public String escuela() {
		return "nuestraEscuela";
	}
	
	@GetMapping("/ubicacion")
	public String ubicacion() {
		return "ubicacion";
	}
	
	@GetMapping("/director")
	public String director() {
		return "director";
	}
}
