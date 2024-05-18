package com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventoRepositorio extends JpaRepository<Evento, Long>{

	@Query("""
			SELECT e FROM Evento e
			WHERE e.fecha = e.fecha
			""")
	List<Evento> eventosPorMes(LocalDate fecha);
	
	/*@Query("""
			SELECT e.nombre, COUNT(a.musico.id) 
			FROM Evento e 
			JOIN e.asiste a 
			GROUP BY e.id
			""")
	public List<Evento> findNumeroMusicosPorEvento();*/
	
	
}

