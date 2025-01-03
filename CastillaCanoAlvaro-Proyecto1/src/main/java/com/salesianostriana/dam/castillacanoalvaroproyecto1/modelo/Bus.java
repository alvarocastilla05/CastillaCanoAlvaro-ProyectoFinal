												package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Builder
public class Bus {

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	
	private int plazas;
	
	private double precioKm;
	
	private double descuento;
	
	@OneToMany(mappedBy="bus", fetch = FetchType.EAGER)
	@Builder.Default
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Evento> eventos = new ArrayList<>();
	
	
	
	
}
