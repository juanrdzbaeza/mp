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
* Abstract class to manage the behavior of their 
* daughters or inherited classes .
* 
* @author Juan Antonio Rodríguez Baeza
* @version 0.1 05/03/2015
*/
public abstract class Figura implements Comparable<Figura>{
	/**
	 * Each figure should have a name as an attribute , later , depending 
	 * on the type of heir figure, have other attributes.
	 */
	private String nombre;
	
	/**
	 * Abstract Method area , forcing any inheriting class heiress Figure
	 * a method to find your area.
	 * @return nothing
	 */
    abstract public double area( );

    /**
     * Constructor of the class, only can name the figure, builders constructed
     * with inherited classes call the parent constructor.
     * @param nombreFigura Figure's name
     */
    public Figura( String nombreFigura ){
        nombre = nombreFigura;
    }

    /**
     * Boolean method to check two figures (one calls the method and one 
     * passed as a parameter ) which is lower.
     * @param lder figure to compare
     * @return true or false
     */
    final public boolean menorQue( Figura lder ){
        return area( ) < lder.area( );
    }
    
    /**
     * Method for generating strings showing that figure ( figure name ) and 
     * its area is about.
     */
    final public String toString( ){
        return nombre + " con area " + area( );
    }
    
    /**
     * Method to return the name of a specific figure.
     * @return String name
     */
    public String getNombre(){
    	return this.nombre;
    }
    
    /**
     * Figure class must implement the Comparable interface, so can implement
     * the compareTo method to compare shapes, in this case compares
     * objects by area
     */
    public int compareTo(Figura f){
    	if (this.area()<f.area()) {
			return -1;
		}else if (this.area()>f.area()) {
			return 1;
		}else {
			return 0;
		}
    }
}