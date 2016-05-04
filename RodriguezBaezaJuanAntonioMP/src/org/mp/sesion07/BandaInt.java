package org.mp.sesion07;

/**
 * BandaInt class. Represents a band of a binary image BSQ stores the 
 * data in int format.
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 *
 */
public class BandaInt {
	
	/**
	 * Attributes:
	 * nombreBanda	-> nombre band name
	 * datos		-> data matrix
	 */
	private String nombreBanda;
	private int[][] datos;

	/**
	 * Constructor BandaInt. Instantiates a BandaInt passing as parameter 
	 * the name of the band, number of columns and number of lines.
	 * 
	 * @param nombre band name
	 * @param x number of columns
	 * @param y numero de lineas
	 */
	public BandaInt(String nombre, int x, int y) {
		nombreBanda = nombre;
		datos = new int[x][y];
	}

	/**
	 * 
	 * @param nombre
	 * @param datos
	 */
	public BandaInt(String nombre, int[][] datos) {
		nombreBanda = nombre;
		this.datos = datos;
	}

	/**
	 * Getter method to return the name of the band
	 * @return nombreBanda name of the band
	 */
	public String getNombreBanda() {
		return nombreBanda;
	}

	/**
	 * Setter method to change the name of the band
	 * @param n new name for the band
	 */
	public void setNombreBanda(String n) {
		nombreBanda = n;
	}

	/**
	 * Getter method to return the data matrix
	 * @return datos data matrix
	 */
	public int[][] getDatos() {
		return datos;
	}

	/**
	 * Setter method to change the data matrix
	 * @param matriz new data matrix
	 */
	public void setDatos(int[][] matriz) {
		datos = matriz;
	}

	/**
	 * Getter method of data (x, y) of the band
	 * @param x column number
	 * @param y line number
	 * @return datos[y][x] data corresponding to the position [x, y]
	 */
	public int getDatoXY(int x, int y) {
		return datos[y][x];
	}

	/**
	 * Setter method data (x, y) of the band, returns the new data
	 * @param dato new data to add
	 * @param x column number
	 * @param y line number
	 * @return datos[y][x] new data corresponding to the position [x, y]
	 */
	public int setDatoXY(int dato, int x, int y) {
		return datos[x][y] = dato;
	}

	/**
	 * Method "toString" of BandaInt. Returns the name of the band
	 * @return nombreBanda
	 */
	@Override
	public String toString() {
		return nombreBanda;
	}
}
