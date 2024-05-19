package com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;
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

	public double porcentajeMusicosAsistentes(Long id) {

		Optional<Evento> eventoOpt = eventoServicio.findBYId(id);

		if (!eventoOpt.isPresent()) {
			throw new IllegalArgumentException("El evento con ID " + id + " no existe.");
		}

		Evento evento = eventoOpt.get();
		int musicosNecesarios = evento.getMusicosNecesarios();

		if (musicosNecesarios == 0) {
			throw new IllegalArgumentException(
					"El evento con ID " + id + " tiene un número de músicos necesarios igual a cero.");
		}
		
		

		int musicosAsistentes = musicoRepositorio.findNumeroMusicosPorEvento(id);

		double porcentaje = ((double) musicosAsistentes / musicosNecesarios) * 100;

		return porcentaje;
	}

}
