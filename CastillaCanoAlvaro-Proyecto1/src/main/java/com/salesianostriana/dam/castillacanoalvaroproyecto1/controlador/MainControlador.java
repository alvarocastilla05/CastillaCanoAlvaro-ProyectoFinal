package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	@GetMapping("/musico/index")
	public String indexMusico() {
		return "index";//Mostramos la plantilla index
	}
	
	@GetMapping("/admin/index")
	public String indexAdmin() {
		return "index";//Mostramos la plantilla index
	}
	
	@GetMapping({"/escuela", "/admin/escuela", "/musico/escuela"})
	public String escuela() {
		return "nuestraEscuela";
	}
	
	@GetMapping({"/ubicacion", "/admin/ubicacion", "/musico/escuela"})
	public String ubicacion() {
		return "ubicacion";
	}
	
	@GetMapping({"/director", "/admin/director", "/musico/escuela"})
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
	
	@GetMapping("/cartas/eventos/concierto/{id}")
	public String verConcierto(@PathVariable("id") long id, Model model) {
		Optional<Concierto> concierto = servicioConcer.findBYId(id);
		
		model.addAttribute("concierto", concierto.get());
		
		return "infoConcierto";
	}
	
	@GetMapping("/cartas/eventos/procesion/{id}")
	public String verProcesion(@PathVariable("id") long id, Model model) {
		Optional<Procesion> procesion = servicioProce.findBYId(id);
		
		model.addAttribute("procesion", procesion.get());
		
		return "infoProcesion";
	}
}
