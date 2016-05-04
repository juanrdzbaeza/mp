package org.mp.sesion03;

/**
 * class to create taxi objects
 * @author Juan Antonio Rodríguez Baeza
 * @version 0.1 20/03/2015
 */

public class Taxi {
	
	/**
	 * Attributes for the taxis
	 * 1)licencia: license number
	 * 2)adaptadoMinusvalido: Accessible to disabled
	 */
	private int licencia;
	private boolean adaptadoMinusvalido;

	/**
	 * Class constructor
	 * @param l license number
	 * @param m Accessible to disabled
	 */
	public Taxi(int l,boolean m){
		licencia 			= l;
		adaptadoMinusvalido = m;
	}
	
	/**
	 * Method to return the license of a taxi
	 * @return int license number
	 */
	public int getLicencia(){
		return this.licencia;
	}
	/**
	 * Method to return if a taxi is adapted for the disabled
	 * @return boolean Accessible to disabled
	 */
	public boolean getMinusvalido(){
		return this.adaptadoMinusvalido;
	}
	/**
	 * Method to check whether two taxis have the same number of license
	 * @param t taxi
	 * @return boolean yes or not
	 */
	public boolean equals(Taxi t){
		return (this.licencia == t.licencia);
	}
	/**
	 * method that returns a string with some attribute 
	 * to recognize every taxi object
	 * @return string List of licenses
	 */
	@Override
	public String toString(){
		return licencia+"";
	}
	
}
