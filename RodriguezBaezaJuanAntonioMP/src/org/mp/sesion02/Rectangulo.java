//
//Universidad de Almer�a 
//Ingenier�a T�cnica de Inform�tica de Sistemas 
//Fuente Java seg�n Plantilla 
//
//PRACTICA : Sesion02 Crear y generar la documentaci�n utilizando la herramienta javadoc
//ASIGNATURA : Metodolog�a de Programaci�n
//
package org.mp.sesion02;

/** 
* Figure heir class. Able to create rectangle objects.
* 
* @author Juan Antonio Rodr�guez Baeza
* @version 0.1 05/03/2015
*/

public class Rectangulo extends Figura{
	/**
	 * The attributes of a rectangle are its base and its height
	 * and its name is acquired by inheritance Figure
	 */
    private double base;
    private double alt;
    
    /**
     * The constructor for the Rectangle class may define rectangles
     * at its base and its height also give them name calling
     * Constructor father.
     * @param largo base of the rectangle
     * @param ancho height of the rectangle
     */    
    public Rectangulo( double largo, double  ancho ){
    	super( (largo==ancho)? "Cuadrado":"Rectangulo" );
    	base = largo;
        alt = ancho;
    }
        
	/**
     * Method inherited area; Rectangle class to calculate the area
     * of a rectangle object according to the formula "A = base x height".
     */
    public double area( ){
        return base * alt;
    }

}