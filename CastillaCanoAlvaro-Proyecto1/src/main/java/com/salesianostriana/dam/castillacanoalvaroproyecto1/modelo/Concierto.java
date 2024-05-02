package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Concierto extends Evento{

	private int aforo;
	
	private boolean gratuito;
	
	private double precioHoraExtra;
}
