package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;

@Controller
public class MusicoControlador {

	@GetMapping("/musico")
	public String showForm(Model model) {
		Musico musico = new Musico();
		model.addAttribute("musicoForm", musico);
		
		return "formularioMusico";
	}
	
	@PostMapping("/addMusico")
	public String submit(@ModelAttribute("musico") Musico musico, Model model) {
		
		model.addAttribute("musico", musico);
		
		return "cuadrillaMusicos";
	}
}
