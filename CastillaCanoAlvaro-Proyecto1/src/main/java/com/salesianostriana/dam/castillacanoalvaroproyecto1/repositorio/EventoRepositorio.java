package com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Bus;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;

public interface EventoRepositorio extends JpaRepository<Evento, Long>{

	@Query("""
			SELECT e FROM Evento e
			WHERE e.fecha = e.fecha
			""")
	List<Evento> eventosPorMes(LocalDate fecha);
	
	/*Revisar*/
	@Query("""
            SELECT e FROM Evento e
            WHERE e.fecha >= CURRENT_DATE
            ORDER BY e.fecha ASC
            LIMIT :cantidad
            """)
    List<Evento> obtenerProximosEventos(@Param("cantidad") int cantidad);
	
	/*@Query("""
			select e from Evento e where e.bus = ?1
			""")
	List<Bus> buscarPorBus(Bus b);*/
	
	
}

