package com.salesianostriana.dam.castillacanoalvaroproyecto1.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Bus;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.BusServicio;

@Controller
@RequestMapping("/admin/bus")
public class BusControlador {

	@Autowired
	private BusServicio busServicio;
	
	@GetMapping("/listaBuses")
	public String listadoBuses(Model model) {
		List<Bus> bus = busServicio.findAll();
		model.addAttribute("bus", bus);
		
		return "admin/tablaBuses";
	}
	
	@GetMapping("/contratar")
	public String formularioBus(Model model) {
		Bus bus = new Bus();
		model.addAttribute("bus", bus);
		
		return "admin/contratarBus";
	}
	
	@PostMapping("/contratar/submit")
	public String guardarBus(@ModelAttribute("bus") Bus bus) {
		busServicio.save(bus);
		return "redirect:/admin/bus/listaBuses";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		Optional<Bus> busEditar = busServicio.findBYId(id);
		
		
		if(busEditar.isPresent()) {
			model.addAttribute("bus", busEditar.get());
			return "/admin/contratarBus";
		}else {
			return "redirect:/admin/bus/listaBuses";
		}
	}
	
	@PostMapping("/editar/submit")
	public String editarBus(@ModelAttribute("bus") Bus bus) {
		busServicio.save(bus);
		return "redirect:/admin/bus/listaBuses";
	}
	
	@GetMapping("/eliminar/{id}")
	public String elimarBus(@PathVariable("id") long id) {
		busServicio.deleteById(id);
		return "redirect:/admin/bus/listaBuses";
	}
}
