package com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Asiste;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.AsistePK;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.TipoInstrumento;
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
	
	
	
	
	
}
