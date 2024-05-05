package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio.MusicoRepositorio;

@Controller
public class MusicoControlador {

	@Autowired
	private MusicoRepositorio repo;
	
	@GetMapping("/listado")
	public String lista(Model model) {
		List<Musico> musico = repo.findAll();
		model.addAttribute("musicoForm", musico);
		
		return "tablaMusicos";
	}
	
	@PostMapping("/addMusico")
	public String submit(@ModelAttribute("musico") Musico musico, Model model) {
		
		model.addAttribute("musico", musico);
		
		return "tablaMusicos";
	}
}
