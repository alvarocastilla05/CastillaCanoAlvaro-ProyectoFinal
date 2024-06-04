package com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Asiste;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.AsistePK;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Evento;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;

public interface AsisteRepositorio extends JpaRepository<Asiste, AsistePK>{
	
	long countByEventoId(Long id);
	
	
	@Query("""
			select a from Asiste a where a.evento = ?1
			""")
	List<Asiste> buscarPorEvento(Evento e);
	
	@Query("""
			select a from Asiste a where a.musico = ?1
			""")
	List<Asiste> buscarPorMusico(Musico m);

	
}
