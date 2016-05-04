package org.mp.sesion04;

// Nodo basico almacenado en una lista enlazada

/**
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 * @param <T> Generic tipe
 */

public class ListNode<T> {
	/**
	 * Attributes:
	 * element Element stored in the node
	 * next Reference to the next node
	 */
	T element;
	ListNode<T> next;

	/**
	 * Constructor for the class
	 * @param theElement
	 */
	public ListNode(T theElement) {
		this.element = theElement;
		this.next = null;
	}
	
	/**
	 * Constructor to create and insert element in list.
	 * @param theElement
	 * @param n - Node list that precedes the inserted
	 */
	public ListNode(T theElement, ListNode<T> n) {
		element = theElement;
		next = n;
	}
}

