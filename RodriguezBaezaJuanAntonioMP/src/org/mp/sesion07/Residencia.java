package org.mp.sesion07;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

/**
 * Class Residendia to instantiate objects residence
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 * 
 */
public class Residencia implements Serializable{

	/**
	 * Attribute:
	 * serialVersionUID	-> 
	 * nombre			-> residence object name
	 * habitaciones		-> list of rooms of the residence object
	 * residentes		-> list of residents of the residence object
	 * reservas			-> lista de reservas, para objeto residencia
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private ArrayList<Habitacion> habitaciones;
	private ArrayList<Residente> residentes;
	private ArrayList<Reserva> reservas;

	/**
	 * Class constructor.- Request a new residence
	 * It generates a new residence, which will have a array of objects 
	 * "Room", an array of objects "Resident" and an array of objects "Reserve".
	 * 
	 * @param nombre Name of the residence
	 * @param habitaciones rooms of the residence.
	 */
	public Residencia(String nombre, Habitacion[] habitaciones) {
		this.nombre = nombre;
		this.habitaciones = new ArrayList<Habitacion>();
		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i] != null) {
				this.habitaciones.add(habitaciones[i]);
			}
		}
		residentes = new ArrayList<Residente>();
		reservas = new ArrayList<Reserva>();
	}

	/**
	 * Insert room.
	 * 
	 * @param h Room to insert
	 */
	public void insertarHabitacion(Habitacion h) {

		if (buscarHabitacion(h.getNumero()) == null) {
			habitaciones.add(h);
		}
	}

	/**
	 * Search room.
	 * 
	 * @param numero String with room number
	 * @return If it find the room with that number returns, otherwise returns null
	 */
	public Habitacion buscarHabitacion(String numero) {

		Iterator<Habitacion> iterador = habitaciones.iterator();
		Habitacion habitacion;
		while (iterador.hasNext()) {
			habitacion = iterador.next();
			if (habitacion.getNumero().equals(numero)) {
				return habitacion;
			}
		}

		return null;

	}

	/**
	 * Remove room.
	 * 
	 * @param h Room to remove
	 */
	public void eliminarHabitacion(Habitacion h) {
		habitaciones.remove(h);

	}

	/**
	 * Entry of a reservation.
	 * 
	 * @param r Resident requesting the reservation.
	 * @param h Room requesting resident
	 * @param entrada Date of entry
	 * @param salida Departure date
	 */
	private void ingresoReserva(Residente r, Habitacion h, Date entrada,
			Date salida) {
		reservas.add(new Reserva(r, h, entrada, salida));
	}

	/**
	 * resident Admission.
	 * 
	 * @param nombre Resident name
	 * @param dni resident identity card
	 * @param sexo resident sex
	 * @param fechaNacimiento Date of Birth resident
	 */
	private void ingresoResidente(String nombre, String dni, char sexo,
			Date fechaNacimiento) {

		boolean residenteExiste = false;

		Iterator<Residente> it = residentes.iterator();
		while (it.hasNext()) {
			Residente r = it.next();
			if (r.getDni().equals(dni)) {
				residenteExiste = true;
				break;
			}
		}

		Residente residente = new Residente(nombre, dni, sexo, fechaNacimiento);
		if (!residenteExiste) {
			residentes.add(residente);
		}

	}

	/**
	 * Public method "ingreso" that makes the resident's entry into the 
	 * room assigned on arrival date and up to the departure
	 * 
	 * @param r Resident to enter
	 * @param h room Selected
	 * @param entrada Date of entry
	 * @param salida Departure date
	 */
	public void ingreso(Residente r, Habitacion h, Date entrada, Date salida) {
		if (entrada.before(salida) || entrada.equals(salida)) {
			if (!(isHabitacionOcupada(h, entrada) || isHabitacionOcupada(h,
					salida))) {
				ingresoReserva(r, h, entrada, salida);
				ingresoResidente(r.getNombre(), r.getDni(), r.getSexo(),
						r.getFechaNacimiento());
			}
		}
	}

	/**
	 * Public method "cambiarHabitacion" if a resident requests changing room, 
	 * made the adjustment method, for it is taken into account if the departure 
	 * has not yet happened. Then a new reservation for the resident, with the 
	 * new room, the entry (no change) and the new departure is generated 
	 * (if necessary, is changed)
	 * 
	 * @param r Resident who requested room change
	 * @param h Room chosen by the resident
	 * @param entrada new Check In
	 * @param salida new Check Out
	 */
	public void cambiarHabitacion(Residente r, Habitacion h, Date entrada,
			Date salida) {
		Date fecha = new Date();
		Iterator<Reserva> iterador = reservas.iterator();
		while (iterador.hasNext()) {
			Reserva reserva = iterador.next();
			if (reserva.getResidente().equals(r) && reserva.getFechaSalida().after(fecha)) {
				reserva.setFechaSalida(fecha);
				break;
			}
		}
		ingresoReserva(r, h, entrada, salida);
	}

	/**
	 * Out of a resident.
	 * If a resident requests exit before completing the reservation system gives check out
	 * 
	 * @param r Resident output
	 * @param salida new Check Out
	 */
	public void salida(Residente r, Date salida) {
		Iterator<Reserva> iterador = reservas.iterator();
		while (iterador.hasNext()) {
			Reserva reserva = iterador.next();
			if (reserva.getResidente().equals(r) && reserva.getFechaSalida().after(salida)) {
				reserva.setFechaSalida(salida);
				break;
			}
		}
		for (int i = 0; i < residentes.size(); i++) {
			Residente residente = residentes.get(i);
			if (residente.equals(r)) {
				residentes.remove(i);
			}
		}

	}
	
	

	/**
	 * Metodo getter del nombre de la residencia
	 * 
	 * @return Nombre de la residencia
	 */
	public String getNombre(){
		return nombre;
	}

	  /*@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&\
	 /@#$%&@#$%&          Getters         $%&@#$%&@#$%\
	/@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&\
*/
	/**
	 * Getter to return the number of rooms
	 * 
	 * @return number of rooms
	 */
	public int getNHabitaciones() {
		return habitaciones.size();
	}

	/**
	 * Getter to return the number of reserves
	 * 
	 * @return number of reserves
	 */
	public int getNReservas() {
		return reservas.size();
	}

	/**
	 * Getter to return the number of residents
	 * 
	 * @return number of residents
	 */
	public int getNResidentes() {
		return residentes.size();
	}

	/**
	 * Getter to return an array of objects resident
	 * 
	 * @return residente ArrayList objects resident
	 */
	public Residente[] getResidentes() {
		Residente[] residente = new Residente[residentes.size()];
		for (int i = 0; i < residente.length; i++) {
			residente[i] = residentes.get(i);
		}
		return residente;
	}

	/**
	 * Getter to return an array of objects room
	 * 
	 * @return habitacion ArrayList objects room
	 */
	public Habitacion[] getHabitaciones() {
		Habitacion[] habitacion = new Habitacion[habitaciones.size()];
		for (int i = 0; i < habitacion.length; i++) {
			habitacion[i] = habitaciones.get(i);
		}
		return habitacion;
	}

	/**
	 * Getter to return an array of objects reserves
	 * 
	 * @return reserva ArrayList objects reserves
	 */
	public Reserva[] getReservas() {
		Reserva[] reserva = new Reserva[reservas.size()];
		for (int i = 0; i < reserva.length; i++) {
			reserva[i] = reservas.get(i);
		}
		return reserva;
	}
	/*
	 * ^Getters^
	 */	
	
	/**
	 * Check whether a room is occupied on a date determiada
	 * 
	 * @param h Room to check whether or not this busy
	 * @param d Date to determine if the room is occupied
	 * @return true if the room is occupied, false otherwise
	 */
	public boolean isHabitacionOcupada(Habitacion h, Date d) {
		Iterator<Reserva> iterador = reservas.iterator();
		while (iterador.hasNext()) {
			Reserva reserva = iterador.next();
			if (reserva.getHabitacion().equals(h) && (reserva.getFechaEntrada().before(d) || reserva.getFechaEntrada().equals(d)) && (reserva.getFechaSalida().after(d) || reserva.getFechaSalida().equals(d))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * List vacancy.
	 * 
	 * @param d Date to check vacancies
	 * @return aux String with free rooms
	 */
	public String listadoHabitacionesLibres(Date d) {
		String aux = "Habitaciones libres a fecha de " + d + ": [";
		Iterator<Habitacion> iterador = habitaciones.iterator();
		while (iterador.hasNext()) {
			Habitacion habitacion = iterador.next();
			if (!isHabitacionOcupada(habitacion, d)) {
				aux += habitacion.getNumero() + " ";
			}
		}
		aux += "]";
		return aux;
	}

	/**
	 * List residents staying in the residence.
	 * 
	 * @param d Date to check residents.
	 * @return aux String con los nombres de los residentes alojados 
	 * 			en la fecha solicitada, con sus habitaciones asignadas.
	 */
	public String listadoResidentesHabitaciones(Date d) {
		Residente[] residenteAux = new Residente[reservas.size()];
		int contResidenteAux = 0;
		String aux = "";
		for(int i=0; i<reservas.size(); i++){
			if(isHabitacionOcupada(reservas.get(i).getHabitacion(),d)){
				residenteAux[contResidenteAux] = reservas.get(i).getResidente();
				contResidenteAux++;
			}
		}
		ordenarAlfabeticamente(residenteAux,contResidenteAux);
		for(int j=0; j<contResidenteAux; j++){
			aux = aux + residenteAux[j].getNombre()+"\n";
		}
		return aux;
	}

	/**
	 * Ordering method an array of residents alphabetically (by name)
	 * @param residentes the array of residents
	 * @param numeroResidentes the number of residents
	 */
	private void ordenarAlfabeticamente(Residente[] residentes, int numeroResidentes){
		Residente temp;
		for(int i = 0; i < numeroResidentes-1; i++){
			for(int j = i+1; j < numeroResidentes; j++){
				if(residentes[j].getNombre().compareToIgnoreCase(residentes[i].getNombre()) < 0){
					temp = residentes[i];
					residentes[i] = residentes[j];
					residentes[j] = temp;
				}
			}
		}
	}
	
	
	/**
	 * List median age by sex.
	 * 
	 * @param d Date for the listing data by sex mean age of residents
	 * @return aux String with the list
	 */
	public String listadoEdadMediaPorSexo(Date d) {
		String aux = "";
		if (getNResidentes() == 0) {
			return "0.0";
		} else {
			double mediaHombres = 0;
			int contHombres = 0;
			double mediaMujeres = 0;
			int contMujeres = 0;

			Iterator<Reserva> iterador = reservas.iterator();
			while (iterador.hasNext()) {
				Reserva reserva = iterador.next();
				if (reserva.getFechaEntrada().before(d) || reserva.getFechaEntrada().equals(d) && reserva.getFechaSalida().after(d) || reserva.getFechaSalida().equals(d)) {
					if (reserva.getResidente().getSexo() == "V".charAt(0)) {
						mediaHombres += reserva.getResidente().getEdad(d);
						contHombres++;
					} else {
						mediaMujeres += reserva.getResidente().getEdad(d);
						contMujeres++;
					}
				}
			}

			aux += "Listado de edad media por sexo:\n";
			if (mediaHombres == 0) {
				aux += "- Media de los hombres: 0.0\n";
			} else {
				aux += "- Media de los hombres: " + mediaHombres / contHombres
						+ "\n";
			}

			if (contMujeres == 0) {
				aux += "- Media de las mujeres: 0.0\n";
			} else {
				aux += "- Media de las mujeres: " + mediaMujeres / contMujeres
						+ "\n";
			}
			return aux;
		}
	}
}
