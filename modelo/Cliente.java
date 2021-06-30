package com.tuempresa.nuevaprueba.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@View(name="Simple", // Esta vista solo se usar� cuando se especifique �Simple�
      members="nro, nombre" // Muestra �nicamente numero y nombre en la misma l�nea
)
public class Cliente {

	@Id
	@Column(length=6)
	int nro;
	
	@Column(length=20)
	@Required
	String nombre;
	
	 
    @Embedded // As� para referenciar a una clase incrustable
    Direccion direccion; // Una referencia Java convenciona
	
	
}
