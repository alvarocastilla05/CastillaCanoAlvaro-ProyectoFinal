package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.AsisteServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.ConciertoServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.MusicoServicio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.ProcesionServicio;

@Controller
@RequestMapping("/admin/musico")
public class MusicoControlador {

	@Autowired
	private MusicoServicio servicio;
	
	@Autowired 
	private AsisteServicio asisteServicio;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@GetMapping("/listado")
	public String lista(Model model, @Param("palabraClave") String palabraClave) {
		List<Musico> musico = servicio.listaAll(palabraClave);
		model.addAttribute("musico", musico);
		model.addAttribute("palabraClave", palabraClave);
		
		return "/admin/tablaMusicos";
	}
	
	@GetMapping("/nuevo")
	public String mostrarFormularioMusico(Model model) {
		Musico musico = new Musico();
		model.addAttribute("musico", musico);
		return "/admin/registroMusico";
	}
	
	@PostMapping("/nuevo/submit")
	public String guardarMusico(@ModelAttribute("musico")Musico musico, Model model) {
		String contrasenia = passwordEncoder.encode(musico.getPassword());
		musico.setPassword(contrasenia);
		
		servicio.save(musico);
		model.addAttribute("musico", musico);
		return "redirect:/admin/musico/listado";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioDeEditarMusico(@PathVariable("id") long id, Model model) {
		Optional<Musico> musicoEditar = servicio.findBYId(id);
		
		if(musicoEditar.isPresent()) {
			model.addAttribute("musico", musicoEditar.get());
			return "/admin/registroMusico";
		}else {
			return "redirect:/admin/musico/listado";
		}
		
	}
	
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("musico") Musico m) {
		servicio.save(m);
		return "redirect:/admin/musico/listado";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarMusico(@PathVariable("id") long id) {
		Optional<Musico> musico = servicio.findBYId(id);

		if(musico.get().isAdmin()) {
			return "errorBorrarAdmin";
		}else {
			/*asisteServicio.findAll().stream().forEach(e -> e.removeFromMusico(servicio.findBYId(id).get()));*/
			//Lo comentado da error porque trato de eliminar la clave primaria de una entidad.
			servicio.deleteById(id);
			
			return "redirect:/admin/musico/listado";
		}
		
		
	}
	
	
	
	
	
}
