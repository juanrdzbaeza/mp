package org.mp.sesion06;

/**
 * Statistics class. It is instantiated by ConjuntoDatos. This class 
 * allows us to obtain average, maximum, minimum and sum of a column.
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 */
public class Estadistica {
	
	/**
	 * Attributes:
	 * conjuntoDeDatos -> object "ConjuntoDatos"
	 */
	private ConjuntoDatos conjuntoDeDatos;

	/**
	 * Constructor of the "Statistics" class. Instantiates object of 
	 * class statistical ConjuntoDatos as assigning a parameter.
	 * 
	 * @param cd object "ConjuntoDatos".
	 */
	public Estadistica(ConjuntoDatos cd) {
		this.conjuntoDeDatos = cd;
	}

	/**
	 * Public method "media". Returns the mean of all the data 
	 * in a column last week by parameter
	 * @param columna Column which will get the average
	 * @return Mean data column
	 */
	public double media(String columna) {
		double[] temp = conjuntoDeDatos.getColumna(columna);
		double media = 0;
		for (int i = 0; i < temp.length; i++) {
			media += temp[i];
		}
		return media / temp.length;
	}

	/**
	 * Method "max". Returns the maximum of all data in a column last week by parameter
	 * @param columna Column which will be the highest
	 * @return max Maximum data column
	 */
	public double max(String columna) {
		double[] temp = conjuntoDeDatos.getColumna(columna);
		double max = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] > max) {
				max = temp[i];
			}
		}
		return max;
	}

	/**
	 * Method "min". Returns the minimum of all the data in a column 
	 * last week by parameter
	 * @param columna column from which you are obtained the minimum
	 * @return min minimum data column
	 */
	public double min(String columna) {
		double[] temp = conjuntoDeDatos.getColumna(columna);

		double min = temp[0];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] < min) {
				min = temp[i];
			}
		}
		return min;
	}

	/**
	 * Method "suma". Returns the sum of all data in a column last week by parameter
	 * 
	 * @param columna of which the sum is obtained
	 * @return suma sum of column data
	 */
	public double suma(String columna) {
		double[] temp = conjuntoDeDatos.getColumna(columna);
		double suma = 0;
		for (int i = 0; i < temp.length; i++) {
			suma += temp[i];
		}
		return suma;
	}
}
