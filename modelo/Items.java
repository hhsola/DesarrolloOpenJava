package com.tuempresa.nuevaprueba.modelo;

import java.math.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter

public class Items {
	@Id
	@Column(length=6)
	int nro;
	
	@Column(length=20)
	@Required
	String nombre;

	 
    @ManyToOne( // La referencia se almacena como una relaci�n en la base de datos
        fetch=FetchType.LAZY, // La referencia se carga bajo demanda
        optional=true) // La referencia puede estar sin valor
    @DescriptionsList // As� la referencia se visualiza usando un combo
    Categoria categoria; // Una referencia Java convencional

    
    @Stereotype("DINERO") // La propiedad precio se usa para almacenar dinero
    BigDecimal precio; // BigDecimal se suele usar para dinero
     
    @Stereotype("GALERIA_IMAGENES") // Una galer�a de fotos completa est� disponible
    @Column(length=32) // La cadena de 32 de longitud es para almacenar la clave de la galer�a
    String fotos;
     
    @Stereotype("TEXTO_GRANDE") // Esto es para un texto grande, se usar� un �rea de texto o equivalente
    String observaciones;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @DescriptionsList
    Autor autor;
    
}
