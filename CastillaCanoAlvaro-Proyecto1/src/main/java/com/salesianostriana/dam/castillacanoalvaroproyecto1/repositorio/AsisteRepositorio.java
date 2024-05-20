package com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Asiste;
import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.AsistePK;

public interface AsisteRepositorio extends JpaRepository<Asiste, AsistePK>{
	
	long countByEventoId(Long id);

	
}
