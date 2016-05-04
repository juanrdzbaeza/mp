package org.mp.sesion06;

import java.io.*;
import java.util.*;

/**
 * ConjuntoDatos class.It allows to process a text file storing file 
 * data, nº lines, nº columns and header.
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 *
 */
public class ConjuntoDatos {
	/**
	 * attributes:
	 * archivoTexto		-> file
	 * separador		-> token
	 * locale			-> text language eg:("English", "US")
	 * cabecera			-> header
	 * numeroLineas		-> number of lines
	 * numeroColumnas	-> number of columns
	 * datos			-> data matrix
	 */
	private File archivoTexto;
	private String separador;
	private Locale locale;
	private List<String> cabecera;
	private int numeroLineas;
	private int numeroColumnas;
	private double[][] datos;

	/**
	 * Class constructor: Instancia un "ConjuntoDatos". Recibe como parametro 
	 * un archivo, el separador de los datos y un locale. Crea la cabecera en 
	 * caso necesario, establece el nº de lineas, columnas y los datos del archivo.
	 * 
	 * @param archivoTexto file processing
	 * @param separador token
	 * @param locale language
	 */
	public ConjuntoDatos(File archivoTexto, String separador, Locale locale){
		this.archivoTexto		= archivoTexto;
		this.separador			= separador;
		this.locale				= locale;
		this.cabecera			= cabecera(archivoTexto);
		this.numeroLineas		= numLineas(archivoTexto);
		this.numeroColumnas		= numColumnas(archivoTexto);
		this.datos				= leerDatos(archivoTexto, numeroLineas, numeroColumnas);
	}

	/**
	 * Private header method. Processes the file for your header,
	 * add it to the header and return List
	 * @param archivoTexto your header file which will be processed, if you have one
	 * @return a List with the head
	 */
	private List<String> cabecera(File archivoTexto){
		cabecera = new ArrayList<String>();
		try {
			// Abrimos el archivo
			FileInputStream fstream = new FileInputStream(archivoTexto);
			// Creamos el objeto de entrada
			DataInputStream entrada = new DataInputStream(fstream);
			// Creamos el buffer de lectura
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					entrada));
			// Leemos la cabecera (1ª línea)
			String temp = buffer.readLine();
			entrada.close();
			String[] temp2 = temp.split(";");
			for (int i = 0; i < temp2.length; i++) {
				cabecera.add(temp2[i]);
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return cabecera;

	}

	/**
	 * Private method that returns the number of lines of a file passed as parameter
	 * @param archivoTexto File to be counted and return lines
	 * @return File number of lines
	 */
	private int numLineas(File archivoTexto){
		try {
			int count;
			// Abrimos el archivo
			FileInputStream fstream = new FileInputStream(archivoTexto);
			// Creamos el objeto de entrada
			DataInputStream entrada = new DataInputStream(fstream);
			// Creamos el buffer de lectura
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					entrada));

			// Comprobamos si el archivo tiene cabecera o no
			String[] temp = buffer.readLine().split(";");
			char c = temp[0].charAt(0);
			if (Character.isLetter(c)) {
				count = -1; // Si hay cabecera
			} else {
				count = 0; // No hay cabecera
			}
			fstream.close();
			fstream = new FileInputStream(archivoTexto);
			entrada = new DataInputStream(fstream);
			buffer = new BufferedReader(new InputStreamReader(entrada));

			// Leer el archivo linea por linea
			while (buffer.readLine() != null) {
				count++;
			}
			entrada.close();
			return count;

		} catch (Exception e) {
			e.getMessage();
		}
		return numeroLineas;
	}


	/**
	 * Private method "numColumnas". Returns the number of columns in a text file.
	 * @param archivoTexto file which count and return the number of columns.
	 * @return File number of columns
	 */
	private int numColumnas(File archivoTexto){
		return cabecera.size();
	}

	/**
	 * Private method "leerDatos". Process data from a text file passed as 
	 * parameter with the number of rows and columns. Reads data from the 
	 * file and returns an array double
	 * @param archivoTexto file which will read the data
	 * @param filas File number of rows
	 * @param columnas File number of columns
	 * @return datos all data in the text file
	 */
	private double[][] leerDatos(File archivoTexto, int filas, int columnas) {
		datos = new double[filas][columnas];
		int count;
		try {
			// Abrimos el archivo
			FileInputStream fstream = new FileInputStream(archivoTexto);
			// Creamos el objeto de entrada
			DataInputStream entrada = new DataInputStream(fstream);
			// Creamos el buffer de lectura
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					entrada));
			// Comprobamos si el archivo tiene cabecera o no
			String[] temp = buffer.readLine().split(";");
			char c = temp[0].charAt(0);
			if (Character.isLetter(c)) {
				count = -1; // Si hay cabecera
			} else {
				count = 0; // No hay cabecera
			}
			fstream.close();
			fstream = new FileInputStream(archivoTexto);
			entrada = new DataInputStream(fstream);
			buffer = new BufferedReader(new InputStreamReader(entrada));
			// Leer el archivo linea por linea
			String linea;
			double temp2;
			while ((linea = buffer.readLine()) != null) {
				if (count >= 0) {
					String[] elementos = linea.split(";");
					for (int i = 0; i < elementos.length; i++) {
						// Si falla el parseo de String a double, por ejemplo en
						// el caso NaN, se asigna un 0
						try {
							temp2 = Double.parseDouble(elementos[i]);
							datos[count][i] = temp2;
						} catch (Exception e) {
							datos[count][i] = 0;

						}
					}
				}
				count++;
			}
			entrada.close();

		} catch (Exception e) {
			e.getMessage();
		}
		return datos;
	}
	
	  /*@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%*\
	 /@#$%&@#$%				geters 				@#$%&@#$%&@\
	/@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&@#$%&\
*/
	/**
	 * Public method "getArchivoTexto". Returns the text file (File)
	 * @return archivoTexto
	 */
	public File getArchivoTexto() {
		return archivoTexto;
	}

	/**
	 * Public method "getSeparador". Returns the separator
	 * @return separador
	 */
	public String getSeparador() {
		return separador;
	}

	/**
	 * Public method "getLocale". Returns the locale
	 * @return locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * Public method "getCabecera". Returns a List with the head
	 * @return cabecera
	 */
	public List<String> getCabecera() {
		return cabecera;
	}

	/**
	 * Public method "getNumeroLineas". Returns the number of lines (int)
	 * @return numeroLineas
	 */
	public int getNumeroLineas() {
		return numeroLineas;
	}

	/**
	 * Public method "getNumeroColumnas". Returns the number of columns (int)
	 * @return numeroColumnas
	 */
	public int getNumeroColumnas() {
		return numeroColumnas;
	}

	/**
	 * Public method "getDatos". Returns an array of data
	 * @return datos
	 */
	public double[][] getDatos() {
		return datos;
	}
	/*
	 * ^geters^
	 */
	
	/**
	 * Public method "getColumna". Returns the data in a column 
	 * last week by parameter, stored on a single vector.
	 * @param columna int index or number of the column to get the data
	 * @return aux all rows in the culumna
	 */
	public double[] getColumna(int columna) {
		double[] aux = new double[numeroLineas];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = datos[i][columna];
		}
		return aux;
	}
	/**
	 * Public method "getColumna". Returns the data in a column 
	 * last week by parameter, stored on a single vector.
	 * @param columna int index or number of the column to get the data
	 * @return columnaTemporal all rows in the culumna
	 */
	public double[] getColumna(String columna) {
		int columnaString = -1;
		String aux;
		Iterator<String> iterador = cabecera.iterator();
		int pos = 0;
		while (true) {
			aux = iterador.next();
			if (aux.equals(columna)) {
				columnaString = pos;
				break;
			}
			pos++;
		}
		double[] columnaTemporal = new double[numeroLineas];
		for (int i = 0; i < columnaTemporal.length; i++) {
			columnaTemporal[i] = datos[i][columnaString];
		}
		return columnaTemporal;
	}

	/**
	 * Public method export. Exports all data CojuntoDatos whose header 
	 * matches the header parameter passed by. This data is stored on 
	 * disk in the path (String archivoTexto) delimited (String separator).
	 * 
	 * @param cabecera String array that contains the header data to be exported
	 * @param archivoTexto text file on disk is the address where the data is stored in the header
	 * @param separador token used to store the file data
	 */
	public void exportar(String[] cabecera, String archivoTexto, String separador) {

		int nColumnas = cabecera.length;
		int count = 0;
		int[] iColumnas = new int[nColumnas];
		String aux = "";

		for (int i = 0; i < this.cabecera.size(); i++) {
			if (this.cabecera.get(i).equals(cabecera[count])) {
				iColumnas[count] = i;
				count++;
				if (count == nColumnas) {
					break;
				}
			}
		}
		try {

			FileWriter fw = new FileWriter(archivoTexto);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			aux = "";
			for (int i = 0; i < cabecera.length; i++) {
				if (i == cabecera.length - 1) {
					aux += cabecera[i];
				} else {
					aux += cabecera[i] + separador;
				}
			}
			pw.println(aux);
			count = 0;
			aux = "";
			for (int linea = 0; linea < datos[0].length; linea++) {
				for (int columna = 0; columna < nColumnas; columna++) {
					if (columna == nColumnas - 1) {
						aux += datos[linea][iColumnas[count]];
						count = 0;
					} else {
						aux += datos[linea][iColumnas[count]] + separador;
						count++;
					}
				}
				pw.println(aux);
				aux = "";
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Public method "conjuntoDatos". Calls the method to export the header 
	 * parameter passed by the separator and the locale, and then returns a 
	 * new instance and starting in the archivoTexto ConjuntoDatos created by export
	 * 
	 * @param cabecera header you will have the conjuntoDatos.
	 * @param archivoTexto text file for data processing
	 * @param separador separator used in the data
	 * @param locale Language data
	 * @return conjuntoDatos returns "conjuntoDatos" with the data passed as parameter
	 */
	public ConjuntoDatos conjuntoDatos(String[] cabecera, String archivoTexto,
			String separador, Locale locale) {
		exportar(cabecera, archivoTexto, separador);
		return new ConjuntoDatos(new File(archivoTexto), separador, locale);
	}
}
