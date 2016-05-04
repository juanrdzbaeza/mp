package org.mp.sesion05;

/**
 * Class Action.
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 *
 */
public class Accion implements Comparable<Accion> {
	
	/**
	 * attributes:
	 * nombre: Action Name
	 * volumen: Volume of the action
	 */
	private String nombre;
	private long volumen;
	
	/**
	 * Action constructor. Request a new action
	 * 
	 * @param nomb Action Name
	 * @param vol Volume of the action
	 */
	public Accion(String nomb, long vol){
		this.nombre		= nomb;
		this.volumen	= vol;
	}
	
	
	/**
	 * Returns the name of the action
	 * @return Action Name
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Returns the amount of the action
	 * @return Volume of the action
	 */
	public long getVolumen() {
		return volumen;
	}

	/**
	 * Assign a new name action
	 * @param nombre renamed the action
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Assigns a new volume of action
	 * @param volumen new volume of action
	 */
	public void setVolumen(long volumen) {
		this.volumen = volumen;
	}
	
	/**
	 * Compare two actions to see if they match, 
	 * which calls the method and passed as parameter
	 * @return true if they are equal, false otherwise
	 */
	public boolean equals(Object o) {
		Accion otraAccion = (Accion) o;
		return this.nombre.equals(otraAccion.getNombre())&& this.volumen == otraAccion.getVolumen();
	}
	
	
	/**
	 * Print the contents of an action
	 * @return content of the action
	 */
	@Override
	public String toString() {
		return "Accion [nombre=" + nombre + ", volumen=" + volumen + "]";
	}


	/**
	 * Compares two actions, calling the method and passed as parameter
	 * 
	 * @return -1, 0, or 1 if the action that calls the method is less than, 
	 * 			equal to or greater than last action as parameter
	 */
	@Override
	public int compareTo(Accion o) {
		Accion otraAccion = (Accion) o;
		if (this.volumen > otraAccion.getVolumen()) {
			return 1;
		} else if (this.volumen < otraAccion.getVolumen()) {
			return -1;
		} else {
			return 0;
		}
	}

}
