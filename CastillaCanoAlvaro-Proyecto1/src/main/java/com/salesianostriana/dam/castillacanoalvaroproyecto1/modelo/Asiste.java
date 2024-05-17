package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;

import java.util.Optional;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Asiste {

	@EmbeddedId
	private AsistePK asistePK = new AsistePK();

	public Asiste(Musico m, Evento e) {
		this.musico = m;
		this.evento = e;
		
	}
	
	private double sueldo;
	
	private boolean enBus;
	
	@ManyToOne
	@MapsId("musico_id")
	@JoinColumn(name = "musico_id")
	private Musico musico;
	
	@ManyToOne
	@MapsId("evento_id")
	@JoinColumn(name = "evento_id")
	private Evento evento;
	
	
	public void addToMusico(Musico m) {
		m.getAsiste().add(this);
		this.musico = m;
	}

	public void removeFromMusico(Musico m) {
		m.getAsiste().remove(this);
		this.musico = null;
	}


	

	
	
}
