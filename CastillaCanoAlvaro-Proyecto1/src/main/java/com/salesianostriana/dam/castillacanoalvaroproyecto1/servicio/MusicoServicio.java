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
	private AsisteServicio asisteServicio;


	public List<Musico> listaAll(String palabraClave) {

		if (palabraClave != null) {
			return musicoRepositorio.findAllByPalabraClave(palabraClave);
		}

		return musicoRepositorio.findAll();

	}
	
	public void eliminarMusicosAsistentes(Musico m) {
		asisteServicio.eliminarMusicosAsociados(m);
	}

}
