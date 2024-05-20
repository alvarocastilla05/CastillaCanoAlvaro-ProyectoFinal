package com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;

public interface MusicoRepositorio extends JpaRepository<Musico, Long>{

	Optional<Musico> findFirstByUsername(String username);
	
	@Query("""
			SELECT m FROM Musico m 
			WHERE CONCAT(m.id, m.nombre, m.apellidos, 
				m.username, m.tipoInstrumento)
				LIKE %?1%
			""")
	public List<Musico> findAllByPalabraClave(String palabraClave);
	
	
	
	
	

	
	
}
