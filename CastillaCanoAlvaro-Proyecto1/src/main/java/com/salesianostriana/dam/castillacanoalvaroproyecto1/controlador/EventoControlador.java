package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Concierto;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Procesion;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.EventoServicio;

@Controller
public class EventoControlador {

	@Autowired
	private EventoServicio servicio;
	
	@GetMapping("/evento")
	public String lista(Model model) {
		List<Evento> evento = servicio.findAll();
		model.addAttribute("evento", evento);
		
		return "eventos";
	}
	
	@GetMapping("/nuevo/procesion")
	public String mostrarFormularioEvento(Model model) {
		Evento procesion = new Procesion();
		model.addAttribute("evento", procesion);
		return "registroProcesion";
	}
	
	@PostMapping("/nuevo/procesion/submit")
	public String guardarProcesion(@ModelAttribute("evento")Evento evento, Model model) {
		servicio.save(evento);
		return "redirect:/eventos";
	}
	
	
}
