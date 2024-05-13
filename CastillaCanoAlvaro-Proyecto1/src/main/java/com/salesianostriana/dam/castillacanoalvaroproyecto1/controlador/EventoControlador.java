package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Concierto;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Procesion;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.BusServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.ConciertoServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.EventoServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.ProcesionServicio;

@Controller
@RequestMapping("/admin/evento")
public class EventoControlador {

	@Autowired
	private EventoServicio servicio;
	
	@Autowired
	private BusServicio busServicio;
	
	@Autowired
	private ProcesionServicio servicioProce;
	
	@Autowired
	private ConciertoServicio servicioConcer;
	
	@GetMapping("/listadoEvento")
	public String lista(Model model) {
		List<Procesion> procesion = servicioProce.findAll();
		List<Concierto> concierto = servicioConcer.findAll();
		model.addAttribute("procesion", procesion);
		model.addAttribute("concierto", concierto);
		
		return "admin/eventos";
	}
	
	//PROCESION
	
	@GetMapping("/nuevo/procesion")
	public String mostrarFormularioProcesion(Model model) {
		Procesion procesion = new Procesion();
		
		model.addAttribute("buses", busServicio.findAll());
		model.addAttribute("procesion", procesion);
		return "admin/registroProcesion";
	}
	
	@PostMapping("/nuevo/procesion/submit")
	public String guardarProcesion(@ModelAttribute("procesion") Procesion procesion) {
		servicioProce.save(procesion);
		return "redirect:/admin/evento/listadoEvento";
	}
	
	@GetMapping("/editar/procesion/{id}")
	public String editarProcesion(@PathVariable("id") long id, Model model) {
		Optional<Procesion> procesionEditar = servicioProce.findBYId(id);

		model.addAttribute("buses", busServicio.findAll());
		if(procesionEditar.isPresent()) {
			model.addAttribute("procesion", procesionEditar.get());
			return "/admin/registroProcesion";
		}else {
			return "redirect:/admin/evento/listadoEvento";
		}
	}
	
	@PostMapping("/editar/procesion/submit")
	public String procesarEdicionProcesion(@ModelAttribute("procesion") Procesion p) {
		servicioProce.save(p);
		return "redirect:/admin/evento/listadoEvento";
	}
	
	@GetMapping("/eliminar/procesion/{id}")
	public String eliminarProcesion(@PathVariable("id") long id) {
		servicioProce.deleteById(id);
		
		return "redirect:/admin/evento/listadoEvento";
	}
	
	//CONCIERTO
	
	@GetMapping("/nuevo/concierto")
	public String mostrarFormularioConcierto(Model model) {
		Concierto concierto = new Concierto();
		model.addAttribute("buses", busServicio.findAll());
		model.addAttribute("concierto", concierto);
		return "/admin/registroConcierto";
	}
	
	@PostMapping("nuevo/concierto/submit")
	public String guardarConcierto(@ModelAttribute("concierto") Concierto concierto) {
		servicioConcer.save(concierto);
		return "redirect:/admin/evento/listadoEvento";
	}
	
	@GetMapping("/editar/concierto/{id}")
	public String editarConcierto(@PathVariable("id") long id, Model model) {
		Optional<Concierto> conciertoEditar = servicioConcer.findBYId(id);
		model.addAttribute("buses", busServicio.findAll());
		
		if(conciertoEditar.isPresent()) {
			model.addAttribute("concierto", conciertoEditar.get());
			return "/admin/registroConcierto";
		}else {
			return "redirect:/admin/evento/listadoEvento";
		}
	}
	
	@PostMapping("/editar/concierto/submit")
	public String procesarEdicionConcierto(@ModelAttribute("concierto") Concierto c) {
		servicioConcer.save(c);
		return "redirect:/admin/evento/listadoEvento";
	}
	
	@GetMapping("/eliminar/concierto/{id}")
	public String eliminarConcierto(@PathVariable("id") long id) {
		servicioConcer.deleteById(id);
		
		return "redirect:/admin/evento/listadoEvento";
	}
	
}
