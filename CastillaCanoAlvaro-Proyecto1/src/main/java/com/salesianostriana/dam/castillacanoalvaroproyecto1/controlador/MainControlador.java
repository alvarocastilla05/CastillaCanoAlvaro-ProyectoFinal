package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Asiste;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.AsisteFormBean;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.AsistePK;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Concierto;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Procesion;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.AsisteServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.ConciertoServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.EventoServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.ProcesionServicio;

@Controller
public class MainControlador {

	@Autowired
	private ProcesionServicio servicioProce;

	@Autowired
	private ConciertoServicio servicioConcer;

	@Autowired
	private AsisteServicio asisteServicio;

	@Autowired
	private EventoServicio eventoServicio;

	@GetMapping("/")
	public String index(Model model) {

		// Obtener los tres próximos eventos
		List<Evento> proximosEventos = eventoServicio.obtenerProximosEventos();

		// Pasar los eventos al modelo
		model.addAttribute("proximosEventos", proximosEventos);

		return "index";// Mostramos la plantilla index
	}

	@GetMapping("/musico/index")
	public String indexMusico() {
		return "index";// Mostramos la plantilla index
	}

	@GetMapping("/admin/index")
	public String indexAdmin() {
		return "index";// Mostramos la plantilla index
	}

	@GetMapping({ "/escuela", "/admin/escuela", "/musico/escuela" })
	public String escuela() {
		return "nuestraEscuela";
	}

	@GetMapping({ "/ubicacion", "/admin/ubicacion", "/musico/escuela" })
	public String ubicacion() {
		return "ubicacion";
	}

	@GetMapping({ "/director", "/admin/director", "/musico/escuela" })
	public String director() {
		return "director";
	}

	@GetMapping({ "/cartas/eventos", "admin/cartas/eventos" })
	public String eventos(Model model) {
		List<Procesion> procesion = servicioProce.findAll();
		List<Concierto> concierto = servicioConcer.findAll();
		model.addAttribute("procesion", procesion);
		model.addAttribute("concierto", concierto);
		return "tarjetasEventos";
	}

	/*
	@GetMapping("/cartas/eventos/concierto/{id}")
	public String verConcierto(@AuthenticationPrincipal Musico musico, @PathVariable("id") long id, Model model) {
		Optional<Concierto> concierto = servicioConcer.findBYId(id);

		double precioBus = eventoServicio.calcularPrecioBus(concierto.get());
		double musicosContratados = eventoServicio.calcularMusicosContratados(concierto.get());
		double dineroEntradas = servicioConcer.calcularPosibleDineroEntradas(concierto.get());
		double ingresosFinales = eventoServicio.calcularIngresosFinales(concierto.get());

		model.addAttribute("concierto", concierto.get());

		boolean mostrarFormulario = false;

		if (musico != null) {
			AsistePK asistePK = new AsistePK(musico.getId(), id);

			// consultar con asisteservicio.findById(...)
			Optional<Asiste> asiste = asisteServicio.findBYId(asistePK);

			AsisteFormBean asisteForm = new AsisteFormBean(id);

			mostrarFormulario = asiste.isEmpty();
			model.addAttribute("asisteForm", asisteForm);
			if (asiste.isPresent())
				model.addAttribute("asiste", asiste.get());

		}

		model.addAttribute("mostrarFormulario", mostrarFormulario);

		model.addAttribute("precioBus", precioBus);
		model.addAttribute("musicosContratados", musicosContratados);
		model.addAttribute("dineroEntradas", dineroEntradas);
		model.addAttribute("ingresosFinales", ingresosFinales);

		asisteServicio.porcentajeMusicosAsistentes(concierto.get());

		double porcentajeAsistentes = asisteServicio.porcentajeMusicosAsistentes(concierto.get());
		model.addAttribute("porcentajeAsistentes", porcentajeAsistentes);

		return "infoConcierto";
	}

	@GetMapping("/cartas/eventos/procesion/{id}")
	public String verProcesion(@AuthenticationPrincipal Musico musico, @PathVariable("id") long id, Model model) {
		Optional<Procesion> procesion = servicioProce.findBYId(id);

		double precioBus = eventoServicio.calcularPrecioBus(procesion.get());
		double musicosContratados = eventoServicio.calcularMusicosContratados(procesion.get());
		double ingresosFinales = eventoServicio.calcularIngresosFinales(procesion.get());

		model.addAttribute("procesion", procesion.get());

		boolean mostrarFormulario = false;

		if (musico != null) {
			AsistePK asistePK = new AsistePK(musico.getId(), id);

			// consultar con asisteservicio.findById(...)
			Optional<Asiste> asiste = asisteServicio.findBYId(asistePK);

			AsisteFormBean asisteForm = new AsisteFormBean(id);

			mostrarFormulario = asiste.isEmpty();
			model.addAttribute("asisteForm", asisteForm);
			if (asiste.isPresent())
				model.addAttribute("asiste", asiste.get());

		}
		model.addAttribute("mostrarFormulario", mostrarFormulario);


		model.addAttribute("precioBus", precioBus);
		model.addAttribute("musicosContratados", musicosContratados);
		model.addAttribute("ingresosFinales", ingresosFinales);

		asisteServicio.porcentajeMusicosAsistentes(procesion.get());

		double porcentajeAsistentes = asisteServicio.porcentajeMusicosAsistentes(procesion.get());
		model.addAttribute("porcentajeAsistentes", porcentajeAsistentes);

		return "infoProcesion";
	}*/
	
	
	@GetMapping("/cartas/eventos/{id}")
	public String verProcesion(@AuthenticationPrincipal Musico musico, @PathVariable("id") long id, Model model) {
		Optional<Evento> evento = eventoServicio.findBYId(id);
		Optional<Concierto> concierto = servicioConcer.findBYId(id);
		

		double precioBus = eventoServicio.calcularPrecioBus(evento.get());
		double musicosContratados = eventoServicio.calcularMusicosContratados(evento.get());
		double ingresosFinales = eventoServicio.calcularIngresosFinales(evento.get());
		double dineroEntradas = servicioConcer.calcularPosibleDineroEntradas(concierto.get());

		model.addAttribute("evento", evento.get());

		boolean mostrarFormulario = false;

		if (musico != null) {
			AsistePK asistePK = new AsistePK(musico.getId(), id);

			// consultar con asisteservicio.findById(...)
			Optional<Asiste> asiste = asisteServicio.findBYId(asistePK);

			AsisteFormBean asisteForm = new AsisteFormBean(id);

			mostrarFormulario = asiste.isEmpty();
			model.addAttribute("asisteForm", asisteForm);
			if (asiste.isPresent())
				model.addAttribute("asiste", asiste.get());

		}
		model.addAttribute("mostrarFormulario", mostrarFormulario);


		model.addAttribute("precioBus", precioBus);
		model.addAttribute("musicosContratados", musicosContratados);
		model.addAttribute("dineroEntradas", dineroEntradas);
		model.addAttribute("ingresosFinales", ingresosFinales);

		asisteServicio.porcentajeMusicosAsistentes(evento.get());

		double porcentajeAsistentes = asisteServicio.porcentajeMusicosAsistentes(evento.get());
		model.addAttribute("porcentajeAsistentes", porcentajeAsistentes);

		return "infoProcesion";
	}
	

	@GetMapping("/evento/fecha/")
	public String eventoPorMes(Model model, @RequestParam("mes") int mes) {
		List<Concierto> concierto = servicioConcer.eventoPorMes(mes);
		List<Procesion> procesion = servicioProce.eventoPorMes(mes);

		model.addAttribute("concierto", concierto);
		model.addAttribute("procesion", procesion);

		return "tarjetasEventos";
	}

}
