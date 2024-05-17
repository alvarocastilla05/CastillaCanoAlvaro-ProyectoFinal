package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Asiste;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.AsisteFormBean;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.AsistePK;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Concierto;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Procesion;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.AsisteServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.ConciertoServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.MusicoServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.ProcesionServicio;

@Controller
public class AsisteControlador {

	@Autowired
	private AsisteServicio asisteServicio;
	
	@Autowired
	private ProcesionServicio procesionServicio;
	
	@Autowired
	private ConciertoServicio conciertoServicio;
	
	@Autowired
	private MusicoServicio musicoServicio;
	
	
	
	@GetMapping("/asociar/procesion/{id}")
	public String asociarMusicoProcesion(@AuthenticationPrincipal Musico musico, @PathVariable("id") Long id) {
		
		
		if(procesionServicio.findBYId(id).isPresent()) {
			
			Procesion p = procesionServicio.findBYId(id).get();
			Asiste asiste = new Asiste(musico, p);
			
			asiste.addToMusico(musico);
			asisteServicio.save(asiste);
			
		}
		return "redirect:/cartas/eventos";
	}
	
	@GetMapping("/asociar/bus/{id}")
	public String asociarBus(@PathVariable("id") long id, Model model) {
		
		if(procesionServicio.findBYId(id).isPresent()) {
			AsisteFormBean asiste = new AsisteFormBean();
			
			model.addAttribute("asisteForm", asiste );
		}
		
		return "infoProcesion";
		
	}
	
	@PostMapping("/asociar/bus/submit")
	public String confirmarEnBus(@ModelAttribute("asisteForm") AsisteFormBean asiste, @AuthenticationPrincipal Musico musico) {
		
		if(asiste.isEnBus()) {
			asisteServicio.findBYId(new AsistePK()).get().setEnBus(true);
		}
		
		return "redirect:/cartas/eventos";
	}
	
	
	@GetMapping("/asociar/concierto/{id}")
	public String asociarMusicoConcierto(@AuthenticationPrincipal Musico musico, @PathVariable("id") Long id) {
		
		
		if(conciertoServicio.findBYId(id).isPresent()) {
			
			Concierto c = conciertoServicio.findBYId(id).get();
			Asiste asiste = new Asiste(musico, c);
			
			
			asiste.addToMusico(musico);
			asisteServicio.save(asiste);
		}
		return "redirect:/cartas/eventos";
	}
	
	
}
