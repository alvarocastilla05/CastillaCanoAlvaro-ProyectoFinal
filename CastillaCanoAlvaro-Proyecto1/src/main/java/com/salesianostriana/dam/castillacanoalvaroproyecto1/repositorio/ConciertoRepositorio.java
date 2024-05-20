package com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Concierto;


public interface ConciertoRepositorio extends JpaRepository<Concierto, Long>{

	@Query("SELECT e FROM Concierto e WHERE MONTH(e.fecha) = :mes")
	List<Concierto> findByMes(@Param("mes") int mes);
}
