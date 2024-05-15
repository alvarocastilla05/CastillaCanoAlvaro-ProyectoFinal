package com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Asiste;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.AsistePK;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Bus;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio.AsisteRepositorio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.base.BaseServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AsisteServicio extends BaseServiceImpl<Asiste, AsistePK, AsisteRepositorio>{

	
	
	public void addToMusicoAndEvento(Musico m, Evento e, Asiste a, Bus b) {
		e.getAsiste().add(a);
		a.setMusico(m);
		m.getAsiste().add(a);
		a.setEvento(e);
		
		b.getAsistentes().add(a);
		a.setBus(b);
	}
	/*
	public void removeFromMusico(Musico m, Evento e, Asiste a) {
		m.getAsiste().remove(this);
		this.musico = null;
	}*/
	
	
	
}
