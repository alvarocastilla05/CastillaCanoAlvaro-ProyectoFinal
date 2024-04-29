package com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.base;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID>{

	List<T> findAll();
	
	Optional<T> findBYId(ID id);
	
	T save(T t);
	
	T edit(T t);
	
	void delete(T t);
	
	void deleteById(ID id);
}
