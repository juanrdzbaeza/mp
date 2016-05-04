package org.mp.sesion02;

/**
 * Class "Carta" to generate cards, implements the Comparable interface
 * 
 * @author Juan Antonio Rodríguez Baeza
 * @version 0.1 18/03/2015
 */
public class Carta implements Comparable<Carta> {
	
	/**
	 * Class attributes
	 * 1)palo: suit of cards
	 * 2)numero: number of card
	 * 3)valor: value relative to the suit
	 */
	private String palo;
	private int numero;
	private int valor;
	
	/**
	 * Class constructor
	 * @param palo suit of cards
	 * @param numero number of card
	 */
	public Carta(String palo, int numero) {
		this.palo	= palo;
		this.numero	= numero;
		switch (palo) {
			case "O":
				this.valor	= 1;
				break;
			case "C":
				this.valor	= 3;
				break;
			case "E":
				this.valor	= 2;
				break;
			case "B":
				this.valor	= 4;
				break;
			default:
				break;
		}
	}

	/**
	 * Method to return the number of card
	 * @return int number
	 */
	public int getNumero(){
		return this.numero;
	}

	/**
	 * Method for generating a string that shows the
	 * attributes of the card
	 */
	@Override
	public String toString() {
		return "Carta [palo=" + palo + ", numero=" + numero + ", valor="+ valor + "]";
	}

	/**
	 * Method to compare two cards
	 */
	@Override
	public int compareTo(Carta o) {
		if (this.valor == o.valor) {
			if (this.numero < o.numero){
				return -1;
			}else if (this.numero > o.numero){
				return 1;
			}else{
				return 0;
			}
		}else if (this.valor < o.valor) {
			return -1;
		}else{
			return 1;
		}
	}
}
