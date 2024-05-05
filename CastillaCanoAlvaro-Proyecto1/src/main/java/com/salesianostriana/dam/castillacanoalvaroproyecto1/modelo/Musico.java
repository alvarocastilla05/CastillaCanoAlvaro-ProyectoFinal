package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
public class Musico {

	@Id @GeneratedValue 
	private Long id;
	
	private String dni;
	
	private String nombre;
	
	private String apellidos;
	
	private String contrasenia;
	
	private String tipoInstrumento;
	
	private LocalDate fechaAlta;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
				name = "asiste",
				joinColumns = @JoinColumn(name="id"),
				inverseJoinColumns = @JoinColumn(name="id_evento")
			)
	@Builder.Default
	private List<Evento> eventos = new ArrayList<>();
	
	public void addEvento(Evento e) {
		this.eventos.add(e);
		e.getMusicos().add(this);
	}
	
	public void removeEvento(Evento e) {
		e.getMusicos().remove(this);
		this.eventos.remove(e);
	}
	
	
	
	
	
}