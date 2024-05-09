package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Procesion extends Evento {

	public Procesion(String nombre, LocalDate fecha, LocalTime hora, double duracion, String ciudad,
			int musicosNecesarios, boolean busContratado, double dineroPagado, String urlImg, String hermandad,
			String titular, double precioHorasExtras) {
		super(nombre, fecha, hora, duracion, ciudad, musicosNecesarios, busContratado, dineroPagado, urlImg);
		this.hermandad = hermandad;
		this.titular = titular;
		this.precioHorasExtras = precioHorasExtras;
	}

	private String hermandad, titular;
	
	private double precioHorasExtras;

	

	
	
	
	
	
	
	
	
}
