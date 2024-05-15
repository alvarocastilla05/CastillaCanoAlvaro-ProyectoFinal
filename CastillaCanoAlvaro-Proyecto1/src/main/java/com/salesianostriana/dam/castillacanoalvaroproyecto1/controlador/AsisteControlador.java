package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Asiste;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Bus;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Procesion;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.AsisteServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.BusServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.MusicoServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.ProcesionServicio;

@Controller
public class AsisteControlador {

	@Autowired
	private AsisteServicio asisteServicio;
	
	@Autowired
	private ProcesionServicio procesionServicio;
	
	@Autowired
	private MusicoServicio musicoServicio;
	
	@Autowired
	private BusServicio busServicio;
	
	
	@GetMapping("/asociar/{id}")
	public String asociarMusicoEvento(@AuthenticationPrincipal Musico musico, @PathVariable("id") Long id) {
		
		
		if(procesionServicio.findBYId(id).isPresent()) {
			
			Procesion p = procesionServicio.findBYId(id).get();
			Asiste asiste = new Asiste(musico, p);
			Bus b = p.getBus();
			
			asisteServicio.addToMusicoAndEvento(musico, p, asiste, b);
			
			
			musicoServicio.edit(musico);
			procesionServicio.edit(p);
			busServicio.edit(b);
		}
		return "redirect:/cartas/eventos";
		
	}
}
