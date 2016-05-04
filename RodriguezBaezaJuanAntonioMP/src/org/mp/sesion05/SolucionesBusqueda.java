package org.mp.sesion05;

/**
 * Class with static methods that implement different algorithms search linear
 * search, recursive and iterative binary search binary search
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 * 
 */

public class SolucionesBusqueda {

	/**
	 * Static method that implements a linear search algorithm. 
	 * It invoked as a search parameter element. Returns the number sought
	 * if found or exception otherwise.
	 * 
	 * @param busca Search element that contains the data and the number sought
	 * @return The number sought
	 * @throws ElementoNoEncontradoException Number not found
	 */
	public static int busquedaLineal(Busqueda busca) throws ElementoNoEncontradoException {

		int buscado 	= busca.getNumBuscado();
		int[] auxiliar 	= busca.getDatos();
		boolean encontrado = false;

		for (int i = 0; i < auxiliar.length; i++) {
			if (buscado == auxiliar[i]) {
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			throw new ElementoNoEncontradoException("No encontrado");
		}

		return buscado;
	}
	
	
	/**
	 * Static method that implements a binary search algorithm iteratively. 
	 * It invoked as a search parameter element. Returns the number sought
	 * if found or exception otherwise.
	 * 
	 * @param busca Search element that contains the data and the number sought
	 * @return The number sought
	 * @throws ElementoNoEncontradoException Number not found
	 */
	public static int busquedaBinariaIter(Busqueda busca) throws ElementoNoEncontradoException {
		int[] datos = busca.getDatos();
		int inicio = 0;
		int fin = datos.length - 1;
		int buscado = busca.getNumBuscado();

		while (inicio <= fin) {
			int pos = (inicio + fin) / 2;
			if (buscado < datos[pos]) {
				fin = pos - 1;
			} else if (buscado > datos[pos]) {
				inicio = pos + 1;
			} else {
				return buscado;
			}
		}
		throw new ElementoNoEncontradoException("No encontrado");
	}
	
	
	/**
	 * Static method that implements a recursive binary search algorithm. 
	 * It invoked as a search parameter element. Returns the number sought 
	 * if found or exception otherwise.
	 * 
	 * @param busca Search element that contains the data and the number sought
	 * @return The number sought
	 * @throws ElementoNoEncontradoException Number not found
	 */
	public static int busquedaBinariaRec(Busqueda busca) throws ElementoNoEncontradoException {

		int[] datos = busca.getDatos();
		int inicio = 0;
		int fin = datos.length - 1;
		int buscado = busca.getNumBuscado();
		return busquedaBinariaRec(datos, inicio, fin, buscado);
	}
	
	/**
	 * Private static method that is called by the method busquedaBinariaRec. 
	 * Performs recursive binary search
	 * 
	 * @param datos where search data array element
	 * @param inicio starting position of the element subset to search
	 * @param fin end position of the element subset to search
	 * @param buscado element to search
	 * @return Returns the element sought if find
	 * @throws ElementoNoEncontradoException Failure to find the searched item, returns 
	 * 			exception not found
	 */
	private static int busquedaBinariaRec(int[] datos, int inicio, int fin, int buscado) throws ElementoNoEncontradoException {
		if (inicio > fin) {
			throw new ElementoNoEncontradoException("No encontrado");
		} else {
			int pos = (inicio + fin) / 2;
			if (buscado < datos[pos]) {
				return busquedaBinariaRec(datos, inicio, pos - 1, buscado);
			} else if (buscado > datos[pos]) {
				return busquedaBinariaRec(datos, pos + 1, fin, buscado);
			} else {
				return buscado;
			}
		}

	}

}
