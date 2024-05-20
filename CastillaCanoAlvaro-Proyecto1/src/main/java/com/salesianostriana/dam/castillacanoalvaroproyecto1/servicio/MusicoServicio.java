package com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.TipoInstrumento;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio.MusicoRepositorio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.base.BaseServiceImpl;

@Service
public class MusicoServicio extends BaseServiceImpl<Musico, Long, MusicoRepositorio> {

	@Autowired
	private MusicoRepositorio musicoRepositorio;

	@Autowired
	private EventoServicio eventoServicio;

	public List<Musico> listaAll(String palabraClave) {

		if (palabraClave != null) {
			return musicoRepositorio.findAllByPalabraClave(palabraClave);
		}

		return musicoRepositorio.findAll();

	}

	public double calcularSueldoMusicoAprox(Musico m, long id) {

		LocalDate fechaActual = LocalDate.now();

		if (m.getTipoInstrumento() == TipoInstrumento.VientoMetal) {
			double sueldoMetal = 0;
			if ((fechaActual.getYear() - m.getFechaAlta().getYear()) >= 5) {
				sueldoMetal = eventoServicio.calcularIngresosFinales(eventoServicio.findBYId(id).get()) * 0.030;
			} else {
				sueldoMetal = eventoServicio.calcularIngresosFinales(eventoServicio.findBYId(id).get()) * 0.025;
			}
			return sueldoMetal;
		} else if (m.getTipoInstrumento() == TipoInstrumento.VientoMadera) {
			double sueldoMadera = 0;
			if ((fechaActual.getYear() - m.getFechaAlta().getYear()) >= 5) {
				sueldoMadera = eventoServicio.calcularIngresosFinales(eventoServicio.findBYId(id).get()) * 0.030;
			} else {
				sueldoMadera = eventoServicio.calcularIngresosFinales(eventoServicio.findBYId(id).get()) * 0.025;
			}
			return sueldoMadera;
		} else {
			double sueldoPercusion = 0;
			if ((fechaActual.getYear() - m.getFechaAlta().getYear()) >= 5) {
				sueldoPercusion = eventoServicio.calcularIngresosFinales(eventoServicio.findBYId(id).get()) * 0.015;
			} else {
				sueldoPercusion = eventoServicio.calcularIngresosFinales(eventoServicio.findBYId(id).get()) * 0.025;
			}
			return sueldoPercusion;
		}
	}

}
