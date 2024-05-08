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
public class Concierto extends Evento{

	private int aforo;
	
	private boolean gratuito;
	
	private double precioHoraExtra;

	public Concierto(String nombre, LocalDate fecha, LocalTime hora, double duracion, String ciudad,
			int musicosNecesarios, double dineroPagado, String urlImg, int aforo,
			boolean gratuito, double precioHoraExtra) {
		super(nombre, fecha, hora, duracion, ciudad, musicosNecesarios, dineroPagado, urlImg);
		this.aforo = aforo;
		this.gratuito = gratuito;
		this.precioHoraExtra = precioHoraExtra;
	}

	
	
	
}
