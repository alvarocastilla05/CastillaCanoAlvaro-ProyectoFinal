package com.salesianostriana.dam.castillacanoalvaroproyecto1.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@Embeddable
@AllArgsConstructor
public class AsistePK implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		private long musico_id;
		private long evento_id;

	
}
