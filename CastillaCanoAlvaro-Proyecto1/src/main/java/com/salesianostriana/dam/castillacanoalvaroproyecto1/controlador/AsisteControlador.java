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

	// Procesion.
	@GetMapping("/asociar/procesion/{id}")
	public String asociarMusicoProcesion(@AuthenticationPrincipal Musico musico, @PathVariable("id") Long id) {

		if (procesionServicio.findBYId(id).isPresent()) {

			Procesion p = procesionServicio.findBYId(id).get();
			Asiste asiste = new Asiste(musico, p);

			asiste.addToMusico(musico);
			asisteServicio.save(asiste);

		}
		return "redirect:/cartas/eventos";
	}

	@GetMapping("/asociar/busProcesion/{id}")
	public String asociarBusProcesion(@PathVariable("id") long id, Model model) {

		if (procesionServicio.findBYId(id).isPresent()) {
			AsisteFormBean asisteForm = new AsisteFormBean(id);

			model.addAttribute("asisteForm", asisteForm);
			return "infoProcesion";
		}

		return "redirect:/cartas/eventos";

	}

	@PostMapping("/asociar/busProcesion/submit")
	public String confirmarEnBusProcesion(@ModelAttribute("asisteForm") AsisteFormBean asisteForm,
			@AuthenticationPrincipal Musico musico, Model model) {

		// 1) Rescatar el evento a partir del id
		// 2) Crear Asiste
		// 3) Asignar si va o no en bus
		// 4) Guardarlo con el servicio de asiste.

		if (procesionServicio.findBYId(asisteForm.getIdEvento()).isPresent()) {
			Asiste asiste = new Asiste();

			if (asisteForm.isEnBus()) {
				asiste.setEnBus(true);

			}

			asiste.setEvento(procesionServicio.findBYId(asisteForm.getIdEvento()).get());
			asiste.setMusico(musico);

			asisteServicio.save(asiste);

		}

		return "redirect:/cartas/eventos";
	}

	// Concierto.

	@GetMapping("/asociar/concierto/{id}")
	public String asociarMusicoConcierto(@AuthenticationPrincipal Musico musico, @PathVariable("id") Long id) {

		if (conciertoServicio.findBYId(id).isPresent()) {

			Concierto c = conciertoServicio.findBYId(id).get();
			Asiste asiste = new Asiste(musico, c);

			asiste.addToMusico(musico);
			asisteServicio.save(asiste);
		}
		return "redirect:/cartas/eventos";
	}

	@GetMapping("/asociar/busConcierto/{id}")
	public String asociarBusConcierto(@PathVariable("id") long id, Model model) {

		if (conciertoServicio.findBYId(id).isPresent()) {
			AsisteFormBean asisteForm = new AsisteFormBean(id);

			model.addAttribute("asisteForm", asisteForm);
			return "infoConcierto";
		}

		return "redirect:/cartas/eventos";

	}

	@PostMapping("/asociar/busConcierto/submit")
	public String confirmarEnBusConcierto(@ModelAttribute("asisteForm") AsisteFormBean asisteForm,
			@AuthenticationPrincipal Musico musico, Model model) {

		// 1) Rescatar el evento a partir del id
		// 2) Crear Asiste
		// 3) Asignar si va o no en bus
		// 4) Guardarlo con el servicio de asiste.

		if (conciertoServicio.findBYId(asisteForm.getIdEvento()).isPresent()) {
			Asiste asiste = new Asiste();

			if (asisteForm.isEnBus()) {
				asiste.setEnBus(true);

			}

			asiste.setEvento(conciertoServicio.findBYId(asisteForm.getIdEvento()).get());
			asiste.setMusico(musico);

			asisteServicio.save(asiste);

		}

		return "redirect:/cartas/eventos";

	}

	@GetMapping("/ver/sueldoProcesion/{id}")
	public String sueldoPorProcesion(@AuthenticationPrincipal Musico m, @PathVariable("id") long id, Model model) {
		double sueldoAproximado = musicoServicio.calcularSueldoMusicoAprox(m, id);
		AsistePK asistePK = new AsistePK(m.getId(), id);

		asisteServicio.findBYId(asistePK).get().setSueldo(sueldoAproximado);

		model.addAttribute("sueldoAproximado", sueldoAproximado);
		model.addAttribute("asiste", asisteServicio.findBYId(asistePK).get());

		return "infoProcesion";
	}
	
	@PostMapping("/ver/sueldoProcesion/submit")
	public String verSueldoProcesion(@ModelAttribute("asiste") Asiste asiste) {
		asisteServicio.save(asiste);
		return "infoProcesion";
	}

	@PostMapping("/ver/sueldoConcierto/{id}")
	public String verSueldoConcierto(@AuthenticationPrincipal Musico m, @PathVariable("id") long id, Model model) {
		double sueldoAproximado = musicoServicio.calcularSueldoMusicoAprox(m, id);
		AsistePK asistePK = new AsistePK(m.getId(), id);

		asisteServicio.findBYId(asistePK).get().setSueldo(sueldoAproximado);

		model.addAttribute("sueldoAproximado", sueldoAproximado);

		return "infoConcierto";
	}

}
