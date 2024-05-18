package com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio.EventoRepositorio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.base.BaseServiceImpl;

@Service
public class EventoServicio extends BaseServiceImpl<Evento, Long, EventoRepositorio>{

	@Autowired
	private EventoRepositorio eventoRepositorio;
	/*
	public List<Musico> musicosPorEvento(){
		return eventoRepositorio.findNumeroMusicosPorEvento();
	}
	*/
	
	
}
