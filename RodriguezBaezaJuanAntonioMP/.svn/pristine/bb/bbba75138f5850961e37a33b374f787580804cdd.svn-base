package org.mp.sesion05;

/**
 * Class Ordenacion Which implements algorithms: Insertion, mergesort, and sort 
 * it solves ordination by comparing a vector of N elements.
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 *
 */
public class Ordenacion {
	/**
	 * Method ordenacionPorInsercion, It is passed a comparable object, 
	 * and calls a second method that solves the ordination
	 * @param a comparable object
	 */
	@SuppressWarnings("rawtypes")
	public static void ordenacionPorInsercion(Comparable[] a){
		ordenacionPorInsercion(a, 0, a.length - 1);
	}

	/**
	 * OrdenacionPorInsercion method that solves the ordination
	 * 
	 * @param a comparable object
	 * @param inicio start of the array
	 * @param fin end of the array (the array lenth of object comparble)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void ordenacionPorInsercion(Comparable[] a, int inicio, int fin){
		int j;
		Comparable auxiliar;
		for (int i = inicio + 1; i <= fin; i++) {
			auxiliar = a[i];
			for (j = i; j > inicio && (auxiliar.compareTo(a[j - 1]) < 0); j--) {
				a[j] = a[j - 1];
			}
			a[j] = auxiliar;
		}
	}

	/**
	 * MergeSort method similar object that is transmitted, 
	 * and calls a second method solves the ordination. Generates an auxiliary 
	 * vector array to store the object itself that then passed as a parameter 
	 * to the method that solves the algorithm
	 * @param datos comparable object
	 */
	@SuppressWarnings("rawtypes")
	public static void mergeSort(Comparable[] a){
		Comparable[] vectorAux = new Comparable[a.length];
		mergeSort(a, vectorAux, 0, a.length - 1);
	}

	/**
	 * mergeSort method that solves the ordination. the mixture is made by the method mezclar
	 * @param datos comparable object
	 * @param vectorAux vector auxiliar (array del objeto comparable)
	 * @param inicio start of the array
	 * @param fin  end of the array
	 */
	@SuppressWarnings("rawtypes")
	private static void mergeSort(Comparable[] datos, Comparable[] vectorAux, int inicio, int fin){
		if (inicio < fin) {
			int centro = (inicio + fin) / 2;
			mergeSort(datos, vectorAux, inicio, centro);
			mergeSort(datos, vectorAux, centro + 1, fin);
			mezclar(datos, vectorAux, inicio, centro + 1, fin);

		}
	}

	/**
	 * Method mezclar. mixing the results obtained in the method 
	 * mergeSort(Comparable[] datos, Comparable[] vectorAux, int inicio, int fin),
	 * and carries out ordination
	 * @param datos comparable object
	 * @param vectorAux vector auxiliar (array del objeto comparable)
	 * @param inicio inicio start of the array
	 * @param centro center of the array
	 * @param fin fin end of the array
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void mezclar(Comparable[] datos, Comparable[] vectorAux, int inicio, int centro, int fin){

		int finIzq = centro - 1;
		int posAux = inicio;
		int numElementos = fin - inicio + 1;
		while ((inicio <= finIzq) && (centro <= fin))
			if (datos[inicio].compareTo(datos[centro]) <= 0)
				vectorAux[posAux++] = datos[inicio++];
			else
				vectorAux[posAux++] = datos[centro++];

		// Copiar el resto de la primera mitad
		while (inicio <= finIzq)
			vectorAux[posAux++] = datos[inicio++];
		// Copiar el resto de la segunda mitad
		while (centro <= fin)
			vectorAux[posAux++] = datos[centro++];
		// Copiar el vector temporal en el original
		for (int i = 0; i < numElementos; i++, fin--)
			datos[fin] = vectorAux[fin];

	}
	
	/**
	 * Method sort using the sort method of the Arrays class of java.util package
	 * @param datos comparable object
	 */
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] datos){
		java.util.Arrays.sort(datos);
	}

}
