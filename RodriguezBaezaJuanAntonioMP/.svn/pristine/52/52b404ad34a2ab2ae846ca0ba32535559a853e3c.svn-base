package org.mp.sesion07;

import java.io.Serializable;
import java.util.Date;

/**
 * Class Reserva. It represents the reserve made by a resident of a hotel
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 */
public class Reserva implements Serializable {

	/**
	 * Attributes
	 * numReservas	-> number of bookings made by the hotel
	 * residente	-> resident object
	 * habitacion	-> object room
	 * fechaEntrada	-> date of entry
	 * fechaSalida	-> departure date
	 * numReserva	-> ID reserve
	 */
	private static int numReservas;
	private Residente residente;
	private Habitacion habitacion;
	private Date fechaEntrada;
	private Date fechaSalida;
	private int numReserva;

	/**
	 * Class constructor: Request a new reservation
	 * 
	 * @param r resident who requested reserve
	 * @param h room requested by the resident for reservation
	 * @param fechaE date of booking
	 * @param fechaS departure of booking
	 */
	public Reserva(Residente r, Habitacion h, Date fechaE, Date fechaS) {
		++numReservas;
		residente = r;
		habitacion = h;
		fechaEntrada = fechaE;
		fechaSalida = fechaS;
		numReserva = numReservas;

	}

	/**
	 * Getter method to return the resident
	 * 
	 * @return residente
	 */
	public Residente getResidente() {
		return residente;
	}

	/**
	 * Getter method to return the room
	 * 
	 * @return habitacion
	 */
	public Habitacion getHabitacion() {
		return habitacion;
	}

	/**
	 * Getter method to return the entry
	 * 
	 * @return fechaEntrada
	 */
	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	/**
	 * Getter method to return the departure
	 * 
	 * @return fechaSalida
	 */
	public Date getFechaSalida() {
		return fechaSalida;
	}

	/**
	 * Getter method to return the ID of the reservation
	 * 
	 * @return numReserva
	 */
	public int getNumeroReserva() {
		return numReserva;
	}

	/**
	 * Getter method to return the last booking ID
	 * 
	 * @return numReservas
	 */
	public static int getUltimoNumero() {
		return numReservas;
	}

	/*/**
	 * * Setter method to change the entry
	 * * @param d nueva fechaEntrada
	 * */
	/*
	 *
	 *public void setfechaEntrada(Date d){
	 *		fechaEntrada = d;
	 *}
	 */
	
	/**
	 * Setter method to change the departure
	 * 
	 * @param d nueva fechaSalida
	 */
	public void setFechaSalida(Date d) {
		fechaSalida = d;
	}

	/**
	 * Compare two reserves
	 * 
	 * @param r compare with reservation that calls the method
	 * @return true if they are equal, false otherwise
	 */
	public boolean equals(Reserva r) {
		return (numReserva == (r.getNumeroReserva())) ? true : false;
	}

}
