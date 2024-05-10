package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Concierto;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Procesion;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.ConciertoServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.ProcesionServicio;


@Controller
public class MainControlador {

	@Autowired
	private ProcesionServicio servicioProce;
	
	@Autowired
	private ConciertoServicio servicioConcer;
	
	
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
	
	@GetMapping("/cartas/eventos")
	public String eventos(Model model) {
		List<Procesion> procesion = servicioProce.findAll();
		List<Concierto> concierto = servicioConcer.findAll();
		model.addAttribute("procesion", procesion);
		model.addAttribute("concierto", concierto);
		return "tarjetasEventos";
	}
}
