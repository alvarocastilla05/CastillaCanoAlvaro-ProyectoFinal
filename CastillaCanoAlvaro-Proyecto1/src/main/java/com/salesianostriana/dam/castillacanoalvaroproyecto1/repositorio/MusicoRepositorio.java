package com.salesianostriana.dam.castillacanoalvaroproyecto1.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo.Musico;

public interface MusicoRepositorio extends JpaRepository<Musico, Long>{

	Optional<Musico> findFirstByUsername(String username);
}
