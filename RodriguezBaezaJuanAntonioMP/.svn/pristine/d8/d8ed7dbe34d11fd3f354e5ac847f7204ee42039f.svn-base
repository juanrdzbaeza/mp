package org.mp.sesion07;

import java.io.Serializable;

/**
 * Claes room. It represents a hotel room
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 *
 */
public class Habitacion implements Serializable {

	/**
	 * Attribute
	 * numero -> room number
	 */
	private String numero;

	/**
	 * Class constructor. Request a new room
	 * 
	 * @param num room number
	 */
	public Habitacion(String num) {
		numero = num;
	}

	/**
	 * Getter method for room number
	 * 
	 * @return room number
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * Setter method for room number
	 * 
	 * @param nuevoNumero room number
	 */
	public void setNumero(String nuevoNumero) {
		numero = nuevoNumero;
	}

	/**
	 * Returns a room like you are calling the method
	 * 
	 * @see java.lang.Object#clone()
	 * @return new Habitacion room cloned
	 */
	public Habitacion clone() {
		return new Habitacion(this.getNumero());
	}

	/**
	 * Compare the room that calls the method with another pass as parameter
	 * 
	 * @param h room to compare with calling the method	 * 
	 * @return true if they are equal, false otherwise
	 */
	public boolean equals(Habitacion h) {
		return (numero.equals(h.numero)) ? true : false;
	}

}