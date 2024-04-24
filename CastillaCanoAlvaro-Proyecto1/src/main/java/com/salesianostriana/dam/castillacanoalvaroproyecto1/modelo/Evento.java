package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Evento {

	@Id @GeneratedValue
	private Long id;
	
	private String nombre;
	
	private String categoriaEvento;
	
	private LocalDate fecha;
	
	private LocalDateTime hora;
	
	private int duracion;
	
	private String lugar;
	
	private int musicosNecesarios;
	
	private double dineroPagado;
}
