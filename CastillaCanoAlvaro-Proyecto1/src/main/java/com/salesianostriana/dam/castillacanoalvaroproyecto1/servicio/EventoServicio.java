package com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Bus;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio.EventoRepositorio;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.base.BaseServiceImpl;

@Service
public class EventoServicio extends BaseServiceImpl<Evento, Long, EventoRepositorio>{

	@Autowired
	private AsisteServicio asisteServicio;
	
	@Autowired
	private EventoRepositorio eventoRepositorio;
	
	public double calcularPrecioBus(Evento e) {
		double precioBus;
		if(e.getBus() != null) {
			 precioBus = e.getBus().getPrecioKm()*e.getKmARecorrer();
			 if(e.getAsiste().size()==e.getBus().getPlazas()) {
				 double precioFinalBus = precioBus - (precioBus*0.2);
				 return precioFinalBus;
			 }
		}else {
			precioBus = 0;
		}
		return precioBus;
	}
	
	
	public double calcularMusicosContratados(Evento e) {
		double musicosAsistentes = Math.ceil((asisteServicio.porcentajeMusicosAsistentes(e) * e.getMusicosNecesarios())/100);
		if(musicosAsistentes < (e.getMusicosNecesarios()*0.8)) {
			
			double musicosMinimos = Math.ceil(e.getMusicosNecesarios()*0.8);
			
			double musicosAContratar = musicosMinimos - musicosAsistentes;
			
			return musicosAContratar;
		}else {
			return 0;
		}
		
	}
	
	public double calcularIngresosFinales(Evento e) {
		
		double ingresoFinal;
		
		ingresoFinal = Math.round(e.getDineroPagado() - (calcularPrecioBus(e)+(e.getDineroPagado()*(calcularMusicosContratados(e)*0.05))));
		
		
		
		return ingresoFinal;
	}
	
	/*Revisar*/
	 public List<Evento> obtenerProximosEventos() {
	        return eventoRepositorio.obtenerProximosEventos(3);
	    }
	 
	 public void eleminarAsistentesEventos(Evento e) {
		 asisteServicio.eliminarAsistentesEventos(e);
	 }
	 
	 /*public void eliminarBusAsociados(Bus b) {
		 List<Bus> buses = eventoRepositorio.buscarPorBus(b);
		 
		 eventoRepositorio.deleteAll(buses);
	 }*/
	}


	
	
