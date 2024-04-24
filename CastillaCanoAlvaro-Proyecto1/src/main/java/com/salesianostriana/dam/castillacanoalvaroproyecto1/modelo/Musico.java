package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Musico {

	@Id @GeneratedValue
	private String dni;
	
	private String nombre;
	
	private String apellidos;
	
	private String contrasenia;
	
	private String tipoInstrumentos;
	
	private LocalDate fechaAlta;
	
	
}
