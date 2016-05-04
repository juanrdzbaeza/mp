package org.mp.sesion07;

import java.util.Date;
import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * resident class. It represents a resident of a hotel
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 *
 */
public class Residente implements Comparable<Object>, Serializable {

	/**
	 * Attributos:
	 * nombre			-> Resident Name
	 * dni				-> resident identity card
	 * sexo				-> resident sex
	 * fechaNacimiento	-> date of birth of resident
	 */
	private String nombre;
	private String dni;
	private char sexo;
	private Date fechaNacimiento;
	


	/**
	 * Class constructor. it can create instances a new resident
	 *
	 * @param nombre Resident Name
	 * @param dni resident identity card
	 * @param sexo resident sex
	 * @param fecha date of birth of resident
	 */
	public Residente(String nombre, String dni, char sexo, Date fecha) {
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		this.fechaNacimiento = fecha;	
	}
		

/*
	@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&
	@#$%&@#$%&		Getters & Setters		@#$%&@#$%&
	@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&
*/
	/**
	 * Metodo getter del nombre de residente
	 *
	 * @return nombre residente
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo getter del dni del residente
	 *
	 * @return dni residente
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Metodo getter de la fecha de nacimiento del residente
	 *
	 * @return fecha nacimiento residente
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Metodo getter del sexo del residente
	 *
	 * @return sexo del residente
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * Metodo setter del nombre del residente
	 *
	 * @param s nombre del residente
	 */
	public void setNombre(String s) {
		nombre = s;
	}

	/**
	 * Metodo setter del dni del residente
	 *
	 * @param s dni a asignar al residente
	 */
	public void setDni(String s) {
		dni = s;
	}

	/**
	 * Metodo setter del sexo del residente
	 *
	 * @param c sexo residente a asignar
	 */
	public void setSexo(char c) {
		sexo = c;
	}

	/**
	 * Metodo setter de la fecha de nacimiento del residente
	 *
	 * @param d fecha nacimiento residente
	 */
	public void setFechaNacimiento(Date d) {
		fechaNacimiento = d;
	}

	/*
	 * ^Getters & Setters^
	 */
	
	/**
	 * Getter to calculate the age of a resident
	 *
	 * @param date date to determine age resident
	 * @return edad age of the resident
	 */
	public int getEdad(Date date){
		int edad;
		String formato="yyyy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
		int anio = Integer.parseInt(dateFormat.format(date));
		int anio2 = Integer.parseInt(dateFormat.format(fechaNacimiento));
		edad = anio - anio2;
		
		formato="MM";
		dateFormat = new SimpleDateFormat(formato);
		int mes = Integer.parseInt(dateFormat.format(date));
		int mes2 = Integer.parseInt(dateFormat.format(fechaNacimiento));
		
		formato="dd";
		dateFormat = new SimpleDateFormat(formato);
		int dia = Integer.parseInt(dateFormat.format(date));
		int dia2 = Integer.parseInt(dateFormat.format(date));
		
		if(mes2 > mes){
			edad--;
		}else if(mes == mes2){
			if(dia2 > dia){
				edad--;
			}
		}
		
		return edad;
	}
	
	/**
	 * Compare two residents
	 *
	 * @param r This resident will be compared to the resident who 
	 * 			has invoked the method
	 * @return true if they are equal, false otherwise
	 */
	public boolean equals(Residente r){
		return (dni.equals(r.getDni())) ? true : false;
	}
	
	/**
	 * Public method "comareTo". Compare two objects "resident" by name.
	 * 
	 * @param o resident object is to be compared with the object that invoked the method
	 * @return 0 if the names are the same, -1 if different
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Object o) {
		Residente r = (Residente) o;
		String[] splitNombre1 = nombre.split(",");
		String nombre1 = splitNombre1[1].replace(" ", "");
		System.out.println(nombre1);
		String[] splitNombre2 = r.getNombre().split(",");
		String nombre2 = splitNombre2[1].replace(" ", "");
		System.out.println(nombre2);
		
		if(nombre1.compareTo(nombre2) == 0){
			return 0;
		}else if(nombre1.compareTo(nombre2) == 1){
			return 1;
		}else{
			return -1;
		}
	}
}