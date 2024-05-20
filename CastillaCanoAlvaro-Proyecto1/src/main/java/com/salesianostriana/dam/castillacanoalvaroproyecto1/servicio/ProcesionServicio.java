package com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Procesion;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio.ProcesionRepositorio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.base.BaseServiceImpl;

@Service
public class ProcesionServicio extends BaseServiceImpl<Procesion, Long, ProcesionRepositorio>{

	@Autowired
	private ProcesionRepositorio procesionRepositorio;
	
	public List<Procesion> eventoPorMes(int mes){
		return procesionRepositorio.findByMes(mes);
	}
}
