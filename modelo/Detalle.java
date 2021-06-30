package com.tuempresa.nuevaprueba.modelo;

import javax.persistence.*;

import lombok.*;
 
@Embeddable @Getter @Setter
public class Detalle {
	   int cantidad;
	   
	    @ManyToOne(fetch = FetchType.LAZY, optional = true)
	    Items producto;
}
