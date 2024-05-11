package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Bus {

	@Id
	@GeneratedValue
	private Long id;
	
	private double kmRecorridos;
	
	private double descuento;
	
}
