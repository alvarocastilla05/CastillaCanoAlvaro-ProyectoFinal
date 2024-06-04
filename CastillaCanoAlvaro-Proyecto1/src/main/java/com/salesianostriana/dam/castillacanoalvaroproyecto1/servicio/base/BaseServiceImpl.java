package com.salesianostriana.dam.castillacanoalvaroproyecto1.servicio.base;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseServiceImpl<T, ID, R extends JpaRepository<T, ID>> 
		implements BaseService<T, ID> {
	
	@Autowired
	protected R repository;

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<T> findBYId(ID id) {
		return repository.findById(id);
	}

	@Override
	public T save(T t) {
		return repository.save(t);
	}

	@Override
	public T edit(T t) {
		return repository.save(t);
	}

	@Override
	public void delete(T t) {
		repository.delete(t);
	}

	@Override
	public void deleteById(ID id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteAll(Collection<T> list) {
		repository.deleteAll(list);
		
	}
	
	
	
	

}
