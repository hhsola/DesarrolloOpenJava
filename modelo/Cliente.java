package com.tuempresa.nuevaprueba.modelo;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@View(name="Simple", // Esta vista solo se usará cuando se especifique “Simple”
      members="nro, nombre" // Muestra únicamente numero y nombre en la misma línea
)
public class Cliente {

	@Id
	@Column(length=6)
	int nro;
	
	@Column(length=20)
	@Required
	String nombre;
	
	 
    @Embedded // Así para referenciar a una clase incrustable
    Direccion direccion; // Una referencia Java convenciona
	
	
}
