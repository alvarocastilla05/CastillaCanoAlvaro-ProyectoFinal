package com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio.MusicoRepositorio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.base.BaseServiceImpl;

@Service
public class MusicoServicio extends BaseServiceImpl<Musico, Long, MusicoRepositorio>{

	@Autowired
	private MusicoRepositorio musicoRepositorio;
	
	public List<Musico> listaAll(String palabraClave){
		
		if(palabraClave != null) {
			return musicoRepositorio.findAllByPalabraClave(palabraClave);
		}
		
		return musicoRepositorio.findAll();
		
	}
	
	
}
