package org.mp.sesion05;

import java.util.Comparator;

/**
 * 
 * VolumenComparator class. Implements comparator.
 * 
 * @author Juan A.Rodriguez Baeza
 * @version 0.1 02/06/2015
 *
 */
@SuppressWarnings("rawtypes")
public class VolumenComparator implements Comparator {
	
	/**
	 * Compares two past actions as parameter
	 * 
	 * @return -1, 1 or 0 in case after the first action as parameter 
	 * 			is lower, higher or equal to the second.
	 */
	public int compare(Object o1, Object o2) {
		Accion tempCast1 = (Accion) o1;
		Accion tempCast2 = (Accion) o2;
		if (tempCast1.getVolumen() > tempCast2.getVolumen()) {
			return 1;
		} else if (tempCast1.getVolumen() < tempCast2.getVolumen()) {
			return -1;
		} else {
			return 0;
		}
	}

}
