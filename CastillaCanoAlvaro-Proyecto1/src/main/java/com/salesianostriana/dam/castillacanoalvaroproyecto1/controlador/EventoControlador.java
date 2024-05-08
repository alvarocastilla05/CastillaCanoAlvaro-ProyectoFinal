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
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.ConciertoServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.EventoServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.ProcesionServicio;

@Controller
public class EventoControlador {

	@Autowired
	private EventoServicio servicio;
	
	@Autowired
	private ProcesionServicio servicioProce;
	
	@Autowired
	private ConciertoServicio servicioConcer;
	
	@GetMapping("/evento")
	public String lista(Model model) {
		List<Evento> evento = servicio.findAll();
		model.addAttribute("evento", evento);
		
		return "eventos";
	}
	
	@GetMapping("/nuevo/procesion")
	public String mostrarFormularioProcesion(Model model) {
		Evento procesion = new Procesion();
		model.addAttribute("evento", procesion);
		return "registroProcesion";
	}
	
	@PostMapping("/nuevo/procesion/submit")
	public String guardarProcesion(@ModelAttribute("evento")Model model, Procesion procesion) {
		servicioProce.save(procesion);
		return "redirect:/evento";
	}
	
	@GetMapping("/nuevo/concierto")
	public String mostrarFormularioConcierto(Model model) {
		Evento concierto = new Concierto();
		model.addAttribute("evento", concierto);
		return "registroConcierto";
	}
	
	@PostMapping("nuevo/concierto/submit")
	public String guardarConcierto(@ModelAttribute("evento")Model model, Concierto concierto) {
		servicioConcer.save(concierto);
		return "redirect:/evento";
	}
	
}
