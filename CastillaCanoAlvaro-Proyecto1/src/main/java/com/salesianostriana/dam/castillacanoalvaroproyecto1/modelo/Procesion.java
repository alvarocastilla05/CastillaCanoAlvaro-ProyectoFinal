package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@Entity
public class Procesion extends Evento {

	private String hermandad, titular;
	
	private double precioHorasExtras;

	
	
	
	
	
	
	
	
}
