package com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Asiste;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.AsistePK;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio.AsisteRepositorio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.base.BaseServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AsisteServicio extends BaseServiceImpl<Asiste, AsistePK, AsisteRepositorio>{

	

	@Autowired
	private AsisteRepositorio asisteRepositorio;

	public double porcentajeMusicosAsistentes(Evento e) {

		int musicosNecesarios = e.getMusicosNecesarios();
	
		if (musicosNecesarios == 0) {
			throw new IllegalArgumentException(
					"El evento con ID " + e.getId() + " tiene un número de músicos necesarios igual a cero.");
		}
		
		long musicosAsistentes = asisteRepositorio.countByEventoId(e.getId());
		

		double porcentaje = Math.round(((double) musicosAsistentes / musicosNecesarios) * 100);

		return porcentaje;
	}

	public void eliminarAsistentesEventos(Evento e) {
		List<Asiste> asistentes = asisteRepositorio.buscarPorEvento(e);
		
		asisteRepositorio.deleteAll(asistentes);
	}
	
	public void eliminarMusicosAsociados(Musico m) {
		List<Asiste> musicos = asisteRepositorio.buscarPorMusico(m);
		
		asisteRepositorio.deleteAll(musicos);
	}
	
	public List<Asiste> buscarMusicosDeEvento(Evento e) {
		return asisteRepositorio.buscarPorEvento(e);
	}
	
	public List<Asiste> buscarEventosDeMusico(Musico m){
		return asisteRepositorio.buscarPorMusico(m);
	}
	
	
	
	
	
}
