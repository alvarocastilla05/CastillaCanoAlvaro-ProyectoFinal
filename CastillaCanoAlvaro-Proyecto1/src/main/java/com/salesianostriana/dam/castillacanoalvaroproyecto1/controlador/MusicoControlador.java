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
import org.springframework.web.servlet.ModelAndView;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio.MusicoRepositorio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.MusicoServicio;

@Controller
public class MusicoControlador {

	@Autowired
	private MusicoServicio servicio;
	
	@GetMapping("/listado")
	public String lista(Model model) {
		List<Musico> musico = servicio.findAll();
		model.addAttribute("musico", musico);
		
		return "tablaMusicos";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormularioMusico(Model model) {
		Musico musico = new Musico();
		model.addAttribute("musico", musico);
		return "registroMusico";
	}
	
	@PostMapping("/nuevo/submit")
	public String guardarMusico(@ModelAttribute("musico")Musico musico, Model model) {
		servicio.save(musico);
		return "redirect:/listado";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioDeEditarMusico(@PathVariable("id") long id, Model model) {
		Optional<Musico> musicoEditar = servicio.findBYId(id);
		
		if(musicoEditar.isPresent()) {
			model.addAttribute("musico", musicoEditar.get());
			return "registroMusico";
		}else {
			return "redirect:/listado";
		}
		
	}
	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("musico") Musico m) {
		servicio.save(m);
		return "redirect:/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarMusico(@PathVariable("id") long id) {
		servicio.deleteById(id);
		
		return "redirect:/listado";
	}
	
	
}
