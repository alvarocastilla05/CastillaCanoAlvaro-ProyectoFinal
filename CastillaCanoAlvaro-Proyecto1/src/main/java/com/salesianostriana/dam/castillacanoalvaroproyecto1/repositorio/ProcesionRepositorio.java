package com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Procesion;

public interface ProcesionRepositorio extends JpaRepository<Procesion, Long>{

	@Query("SELECT e FROM Procesion e WHERE e.fecha.getMonthValue() = :mes")
	List<Procesion> findByMes(@Param("mes") int mes);
}
