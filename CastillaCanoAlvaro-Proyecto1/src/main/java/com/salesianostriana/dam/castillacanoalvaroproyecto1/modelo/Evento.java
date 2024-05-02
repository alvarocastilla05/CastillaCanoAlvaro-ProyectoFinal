package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Evento {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	
	private LocalDate fecha;
	
	private LocalTime hora;
	
	private double duracion;
	
	private String ciudad;
	
	private int musicosNecesarios;
	
	private double dineroPagado;
	
	private String urlImg;
	
	//Completar atributos están incompletos.
}
