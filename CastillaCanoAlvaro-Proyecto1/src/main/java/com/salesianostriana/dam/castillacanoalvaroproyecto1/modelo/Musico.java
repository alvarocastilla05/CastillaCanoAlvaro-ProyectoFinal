package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Musico {

	@Id @GeneratedValue 
	private Long id;
	
	private String nombre;
	
	private String apellidos;
	
	private String usuario;
	
	private String contrasenia;
	
	@Enumerated(value = EnumType.STRING)
	private TipoInstrumento tipoInstrumento;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaAlta;
	
	@OneToMany(mappedBy="musico", fetch = FetchType.EAGER)
	@Builder.Default
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Asiste> asiste = new ArrayList<>();
	
	
	
	
	
	
	
}