package org.mp.sesion05;

import java.util.Arrays;
import java.util.Comparator;



/**
 * Class orders a deck of cards. The orders by various criteria, first by number,
 * from lowest to highest, and if you have the same number, the order by suit
 * in this order: (Gold, Cups, Swords, Wands)
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 *
 */
@SuppressWarnings("rawtypes")
public class NumeroPaloComparator implements Comparator {


	/**
	 * Metodo publico que compara dos objetos de tipo Carta
	 * 
	 * @param naipe1 First card to compare
	 * @param naipe2 Second card to compare
	 * @return Return -1 or 1 if the first card is less than or greater
	 * than the second. No returns 0 since in a deck should not have two cards
	 * of the same number and stick.
	 */
	@Override
	public int compare(Object naipe1, Object naipe2) {
		Carta carta1 = (Carta) naipe1;
		Carta carta2 = (Carta) naipe2;

		if (carta1.getNumero() == carta2.getNumero()) {
			if (carta1.getPalo().equals("O"))
				return -1;
			if (carta2.getPalo().equals("O"))
				return 1;
			if (carta1.getPalo().equals("C"))
				return -1;
			if (carta1.getPalo().equals("E")) {
				if (carta2.getPalo().equals("B"))
					return -1;
			} else {
				return 1;
			}
			if (carta1.getPalo().equals("B"))
				return 1;

		} else {
			if (carta1.getNumero() > carta2.getNumero()) {
				return 1;
			} else {
				return -1;
			}
		}
		return 0;		
	}
}
