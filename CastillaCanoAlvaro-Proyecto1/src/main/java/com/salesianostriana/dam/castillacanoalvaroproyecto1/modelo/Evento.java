package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Builder
public class Evento {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nombre;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	
	private LocalTime hora;
	
	private double duracion;
	
	private String ciudad;
	
	private double kmARecorrer;
	
	private int musicosNecesarios;
	
	private boolean busContratado;
	
	private double dineroPagado;
	
	private String urlImg;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_evento_bus"))
	private Bus bus;
	
	@OneToMany(mappedBy="evento", fetch = FetchType.EAGER)
	@Builder.Default
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Asiste> asiste = new ArrayList<>();
	
	public Evento(String nombre, LocalDate fecha, LocalTime hora, double duracion, String ciudad, double kmARecorrer,
			int musicosNecesarios, boolean busContratado, double dineroPagado, String urlImg, Bus bus) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.hora = hora;
		this.duracion = duracion;
		this.ciudad = ciudad;
		this.kmARecorrer = kmARecorrer;
		this.musicosNecesarios = musicosNecesarios;
		this.busContratado = busContratado;
		this.dineroPagado = dineroPagado;
		this.urlImg = urlImg;
		this.bus = bus;
	}
	
	public void addToBus(Bus b) {
		b.getEventos().add(this);
		this.bus = b;
	}

	public void removeFromBus(Bus b) {
		b.getEventos().remove(this);
		this.bus = null;
	}
	
	
	
	

	
	
	

	
	
	
}
