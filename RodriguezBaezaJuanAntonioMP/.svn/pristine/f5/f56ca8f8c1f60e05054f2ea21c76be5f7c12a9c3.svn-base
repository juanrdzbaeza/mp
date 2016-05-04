//
//Universidad de Almería 
//Ingeniería Técnica de Informática de Sistemas 
//Fuente Java según Plantilla 
//
//PRACTICA : Sesion02 Crear y generar la documentación utilizando la herramienta javadoc
//ASIGNATURA : Metodología de Programación
//
package org.mp.sesion02;

/** 
* Figure heir class. Circles able to create objects.
* 
* @author Juan Antonio Rodríguez Baeza
* @version 0.1 05/03/2015
*/

public class Circulo extends Figura{
	/**
	 * The attributes of a circle are its radius and static PI attribute
	 * shared by all circle objects to calculate its area and its name
	 * is acquired by inheritance Figure
	 */
	private static final double PI = 3.14159265358979323;
    private double radio;
	
    /**
     * The constructor for the class may define circles for his
     * radio, also will give them name calling constructor father.
     * @param r circle's radius
     */
    public Circulo( double r ){
        super( "Circulo" );
        radio = r;
    }

    /**
     * Method inherited area; for the Circle class will calculate the area
     * of a circle object according to the formulates "A = Pi  x  r^2".
     */
    public double area( ){
    	return PI * radio * radio;
    }

}