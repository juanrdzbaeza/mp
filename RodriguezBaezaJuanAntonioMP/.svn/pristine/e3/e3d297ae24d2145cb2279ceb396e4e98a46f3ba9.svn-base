package org.mp.sesion04;

/**
 * 
 * Class LinkedList for make linked list with iterator and sorted
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 * @param <T> Generic tipe
 */

public class LinkedListIteratorSorted<T> extends LinkedListIterator<T> {

	/**
	 * constructor of the class
	 * @param list
	 */
	public LinkedListIteratorSorted(LinkedList<T> list) {
		super(list);
	}
	
	/**
	 * method add X inserted neatly in the LinkedList, from lowest to highest
	 * @throws NoSuchElementException Linked List is no header node
	 */
	public void add(T x) throws NoSuchElementException {
		if (theList.headNode == null) {
			throw new NoSuchElementException("Linked List no inicializada");

		}
		addSorted((Comparable<T>) x);
	}
	
	/**
	 * Private method that performs the operation of adding orderly method add
	 * @param x
	 * @throws NoSuchElementException
	 */
	public void addSorted(Comparable<T> x) throws NoSuchElementException {
		// si la lista esta vacia, inserta x al next del headNode
		if (current == null) {
			theList.headNode.next = new ListNode<T>((T) x);
			first();
		} else {

			first();
			while (current.next != null) {
				next();
			}
			if (x.compareTo((T) current.element) > 0) {
				current.next = new ListNode<T>((T) x);
				next();
			} else {

				ListNode<T> nodoTemp = null;
				zero();
				// se compara x con los elementos de los nodos desde el primero
				// hasta el ultimo, si x es menor se inserta antes que el nodo
				// en cuestion
				while (current.next != null) {
					if ((x.compareTo((T) current.next.element) < 0)) {
						nodoTemp = current.next;
						current.next = new ListNode<T>((T) x);
						current.next.next = nodoTemp;
						break;
					}
					next();
				}
				/*
				 * Si el valor es mayor que todos los almacenados en la lista,
				 * // lo // insertamos al final if (!addOk) { current.next = new
				 * ListNode<T>((T) x); current = current.next; }
				 */
			}
		}

	}
}
