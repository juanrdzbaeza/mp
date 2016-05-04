package org.mp.sesion05;

import java.util.Random;

/**
 * Class "Baraja" to generate decks
 * 
 * @author Juan Antonio Rodríguez Baeza
 * @version 0.1 18/03/2015 *
 */
public class Baraja {

	/**
	 * Attributes deck
	 * 1)nombreBaraja: the deck name (eg Spanish, French)
	 * 2)cartas: array to store card objects
	 */
	private String nombreBaraja;
	private Carta[] cartas;
	
	/**
	 * class constructor
	 * @param string deck name
	 * @param cartas2 array
	 */
	public Baraja(String string, Carta[] cartas2) {
		this.nombreBaraja	= string;
		this.cartas			= cartas2;
	}

	/**
	 * Method that returns the array of cards in the deck
	 * @return cartas
	 */
	public Carta[] getCartas() {
		return this.cartas;
	}

	/**
	 * Sorting method by insertion
	 * @param baraja object deck to order
	 */
	public static void insercion(Baraja baraja){
		
		for(int i = 1; i < baraja.cartas.length; i++){
			Carta naipe = baraja.cartas[i];
			int j;
			for(j = i-1; j >= 0 && naipe.compareTo(baraja.cartas[j]) < 0; j--){
				baraja.cartas[j+1] = baraja.cartas[j];
			}
			baraja.cartas[j+1] = naipe;
		}
	}
}
