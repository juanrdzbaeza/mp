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
* Heir Rectangle class. Able to create square objects. Square
* attributes making class inheritance rectangle (base and height)
* with the difference that in the case of a square side needs
* only one attribute; this nuance will treat the class constructor.
* 
* @author Juan Antonio Rodr�guez Baeza
* @version 0.1 05/03/2015
*/

public class Cuadrado extends Rectangulo{
	
	/**
	 * The constructor of the class may define Square square
	 * from a single attribute side, making a call to the parent
	 * constructor (Rectangle), which passes the next attribute to
	 * construct a rectangle with base = height = side.
	 * @param lado side of square
	 */
	public Cuadrado( double lado ){
        super( lado, lado );
    }
	
}