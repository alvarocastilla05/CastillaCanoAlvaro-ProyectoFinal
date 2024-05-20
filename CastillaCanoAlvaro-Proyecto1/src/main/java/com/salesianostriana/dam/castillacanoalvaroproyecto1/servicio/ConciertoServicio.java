package com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Concierto;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio.ConciertoRepositorio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.base.BaseServiceImpl;

@Service
public class ConciertoServicio extends BaseServiceImpl<Concierto, Long, ConciertoRepositorio>{

	public double calcularPosibleDineroEntradas(Concierto c) {

		return c.getAforo()*c.getPrecio();
	}
}
