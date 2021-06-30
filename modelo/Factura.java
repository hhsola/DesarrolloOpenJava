package com.tuempresa.nuevaprueba.modelo;

import java.time.*;
import java.util.*;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;

import com.tuempresa.nuevaprueba.calculadores.*;

import lombok.*;

@Entity
@Getter @Setter
@View(members= 
"anyo, numero, fecha;" + 
"cliente;" + 
"detalles;" +
"observaciones"
)
public class Factura {
    @Id
    @GeneratedValue(generator="system-uuid")
    @Hidden
    @GenericGenerator(name="system-uuid", strategy="uuid")
    @Column(length=32)
    String oid;
 
    @Column(length=4)
    @DefaultValueCalculator(CurrentYearCalculator.class) // A�o actual
    int anyo;
 
    @Column(length=6)
    @DefaultValueCalculator(value=CalculadorSiguienteNumeroParaAnyo.class,
    properties=@PropertyValue(name="anyo") // Para inyectar el valor de anyo de Factura
                                           // en el calculador antes de llamar a calculate()
                           )
    int numero;
 
    @Required
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fecha;
 
    @ManyToOne(fetch=FetchType.LAZY, optional=false) 
    @ReferenceView("Simple") 
    Cliente cliente;
    
    @ElementCollection
    @ListProperties("producto.nro, producto.nombre, cantidad")
    Collection<Detalle> detalles;
    
    @Stereotype("MEMO")
    String observaciones;
 

}
