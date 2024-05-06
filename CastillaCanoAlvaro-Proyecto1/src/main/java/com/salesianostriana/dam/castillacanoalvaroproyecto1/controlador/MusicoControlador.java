package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import java.util.List;

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

@Controller
public class MusicoControlador {

	@Autowired
	private MusicoRepositorio repo;
	
	@GetMapping("/listado")
	public String lista(Model model) {
		List<Musico> musico = repo.findAll();
		model.addAttribute("musico", musico);
		
		return "tablaMusicos";
	}
	
	@GetMapping("/nuevoMusico")
	public String mostrarFormularioMusico(Model model) {
		Musico musico = new Musico();
		model.addAttribute("musico", musico);
		return "registroMusico";
	}
	
	@PostMapping("/guardar")
	public String guardarMusico(@ModelAttribute("musico")Musico musico, Model model) {
		repo.save(musico);
		return "redirect:/listado";
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView mostrarFormularioDeEditarMusico(@PathVariable(name = "id") Long id) {
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarMusico(@PathVariable(name = "id") Long id) {
		Musico musico = repo.getReferenceById(id);
		repo.delete(musico);
		
		return "redirect:/listado";
	}
	
	
}
