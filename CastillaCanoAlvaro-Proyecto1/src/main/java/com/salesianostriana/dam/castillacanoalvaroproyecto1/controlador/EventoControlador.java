package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;

@Controller
public class EventoControlador {

	@GetMapping("/evento")
	public String showForm(Model model) {
		Evento evento = new Evento();
		model.addAttribute("eventoForm", evento);
		
		return "registroEvento";
	}
	
	@PostMapping("addEvento")
	public String submit(@ModelAttribute("evento") Evento evento, Model model) {
		
		model.addAttribute("evento", evento);
		
		return "tablaEvento";
	}
}
