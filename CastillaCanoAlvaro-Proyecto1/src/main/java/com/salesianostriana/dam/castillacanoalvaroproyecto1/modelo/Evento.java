package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
	@ManyToMany(mappedBy="eventos", fetch = FetchType.EAGER)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private List<Musico> musicos = new ArrayList<>();

	

	public Evento(String nombre, LocalDate fecha, LocalTime hora, double duracion, String ciudad,
			int musicosNecesarios, double dineroPagado, String urlImg) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.hora = hora;
		this.duracion = duracion;
		this.ciudad = ciudad;
		this.musicosNecesarios = musicosNecesarios;
		this.dineroPagado = dineroPagado;
		this.urlImg = urlImg;
	}

	
	
	
}
