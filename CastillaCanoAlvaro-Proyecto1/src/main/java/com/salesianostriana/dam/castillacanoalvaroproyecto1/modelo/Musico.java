package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	private String tipoInstrumento;
	
	private LocalDate fechaAlta;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_musico_evento"))
	private Evento evento;
}