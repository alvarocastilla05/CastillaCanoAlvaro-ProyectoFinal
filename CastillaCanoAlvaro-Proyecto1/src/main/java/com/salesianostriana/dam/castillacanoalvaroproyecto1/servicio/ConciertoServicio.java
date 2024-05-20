package com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Concierto;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio.ConciertoRepositorio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.base.BaseServiceImpl;

@Service
public class ConciertoServicio extends BaseServiceImpl<Concierto, Long, ConciertoRepositorio>{

	@Autowired
	private ConciertoRepositorio conciertoRepositorio;
	
	public List<Concierto> eventoPorMes(int mes){
		return conciertoRepositorio.findByMes(mes);
	public double calcularPosibleDineroEntradas(Concierto c) {

		return c.getAforo()*c.getPrecio();
	}
}
