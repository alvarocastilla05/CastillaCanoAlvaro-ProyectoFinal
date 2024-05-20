package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsisteFormBean {

	private long idEvento;
	private boolean enBus;
	private double sueldo;
	
	public AsisteFormBean(Long id) {
		this.idEvento = id;
	}
	
	
	
}
