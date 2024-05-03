package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)

public class Procesion extends Evento {

	public Procesion(String nombre, LocalDate fecha, LocalTime hora, double duracion, String ciudad,
			int musicosNecesarios, double dineroPagado, String urlImg, List<Musico> musicos, String hermandad,
			String titular, double precioHorasExtras) {
		super(nombre, fecha, hora, duracion, ciudad, musicosNecesarios, dineroPagado, urlImg);
		this.hermandad = hermandad;
		this.titular = titular;
		this.precioHorasExtras = precioHorasExtras;
	}

	private String hermandad, titular;
	
	private double precioHorasExtras;

	

	
	
	
	
	
	
	
	
}
