package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.AsisteFormBean;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Concierto;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Procesion;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.AsisteServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.ConciertoServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.EventoServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.MusicoServicio;
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
	public String index() {
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

	@GetMapping("/cartas/eventos/concierto/{id}")
	public String verConcierto(@PathVariable("id") long id, Model model) {
		Optional<Concierto> concierto = servicioConcer.findBYId(id);

		
		double precioBus = eventoServicio.calcularPrecioBus(servicioConcer.findBYId(id).get());
		double musicosContratados = eventoServicio.calcularMusicosContratados(servicioConcer.findBYId(id).get());
		double dineroEntradas = servicioConcer.calcularPosibleDineroEntradas(servicioConcer.findBYId(id).get());
		double ingresosFinales = eventoServicio.calcularIngresosFinales(servicioConcer.findBYId(id).get());
		

		model.addAttribute("concierto", concierto.get());

		AsisteFormBean asiste = new AsisteFormBean(id);

		model.addAttribute("asisteForm", asiste);

		
		model.addAttribute("precioBus", precioBus);
		model.addAttribute("musicosContratados", musicosContratados);
		model.addAttribute("dineroEntradas", dineroEntradas);
		model.addAttribute("ingresosFinales", ingresosFinales);
		

		asisteServicio.porcentajeMusicosAsistentes(servicioConcer.findBYId(id).get());

		double porcentajeAsistentes = asisteServicio.porcentajeMusicosAsistentes(servicioConcer.findBYId(id).get());
		model.addAttribute("porcentajeAsistentes", porcentajeAsistentes);

		return "infoConcierto";
	}

	@GetMapping("/cartas/eventos/procesion/{id}")
	public String verProcesion(@PathVariable("id") long id, Model model) {
		Optional<Procesion> procesion = servicioProce.findBYId(id);

		double precioBus = eventoServicio.calcularPrecioBus(servicioProce.findBYId(id).get());
		double musicosContratados = eventoServicio.calcularMusicosContratados(servicioProce.findBYId(id).get());
		double ingresosFinales = eventoServicio.calcularIngresosFinales(servicioProce.findBYId(id).get());

		model.addAttribute("procesion", procesion.get());

		AsisteFormBean asiste = new AsisteFormBean(id);

		model.addAttribute("asisteForm", asiste);

		
		model.addAttribute("precioBus", precioBus);
		model.addAttribute("musicosContratados", musicosContratados);
		model.addAttribute("ingresosFinales", ingresosFinales);
		

		asisteServicio.porcentajeMusicosAsistentes(servicioProce.findBYId(id).get());

		double porcentajeAsistentes = asisteServicio.porcentajeMusicosAsistentes(servicioProce.findBYId(id).get());
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
