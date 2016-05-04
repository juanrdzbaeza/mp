package org.mp.sesion04;

/**
 * Class LinkedList for make linked list with iterator
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 * @param <T> Generic tipe
 */
public class LinkedListIterator<T> implements ListIterator<T> {
	/**
	 * Attributes
	 * theList 
	 * current
	 */
	protected LinkedList<T> theList;
	protected ListNode<T> current;
	
	/**
	 * constructor for the class
	 */
	public LinkedListIterator(LinkedList<T> list) {
		this.theList = list;
		this.current = null;
	}

	/**
	 * method for add one node to the list, if it is possible, because first check if is empty.
	 * @param x element to add
	 * @throws NoSuchElementException
	 */
	@Override
	public void add(T x) throws NoSuchElementException {
		if (this.theList.headNode == null){
			throw new NoSuchElementException("Linked List no inicializada");
		}
		if (current == null) {
			this.theList.headNode.next = new ListNode<T>(x);
			this.current = theList.headNode.next;
		} else {
			this.current.next = new ListNode<T>(x);
			next();
			// current = current.next;
		}
	}

	/**
	 * method for remove one element to the list
	 */
	@Override
	public void remove(T x) throws NoSuchElementException {
		ListNode<T> auxiliar = this.theList.headNode;
		boolean removeOk = false;
		while (auxiliar.next != null) {
			if (auxiliar.next.element.equals(x)) {
				auxiliar.next = auxiliar.next.next;
				removeOk = true;
				break;
			}
			auxiliar = auxiliar.next;
		}
		if (!removeOk) {
			throw new NoSuchElementException("Elemento no encontrado");
		}		
	}

	/**
	 * method to set the current position to the first node containing x
	 */
	@Override
	public boolean contains(T x) throws NoSuchElementException {
		ListNode<T> auxiliar = this.theList.headNode;
		boolean containsOk = false;
		while (auxiliar.next != null) {
			if (auxiliar.element != null) {
				if (auxiliar.element.equals(x)) {
					current = auxiliar;
					containsOk = true;
					break;
				}
			}
			auxiliar = auxiliar.next;
		}
		if (!containsOk) {
			throw new NoSuchElementException("Elemento no encontrado");
		}
		return true;
	}

	/**
	 * Method to set current position the head node
	 */
	@Override
	public void zero() {
		current = this.theList.headNode;		
	}

	/**
	 * Current position on the first node of the list
	 * @throws NoSuchElementException header node does not have assigned next node
	 */
	@Override
	public void first() throws NoSuchElementException {
		if (theList.isEmpty()) {
			throw new NoSuchElementException("LinkedList Vacia");
		}
		current = theList.headNode.next;		
	}

	/**
	 * Advances the current position to the next node in the list.
	 */
	@Override
	public void next() {
		current = current.next;
	}

	/**
	 * Check the current reference position a node from the list.
	 * @return true or false
	 */
	@Override
	public boolean hasNext() {
		return current != null;
	}

	/**
	 * Returns the element node of the current position of the list.
	 * @return generic element node of the current position
	 * @throws NoSuchElementException empty linked list
	 */
	@Override
	public T get() throws NoSuchElementException {
		if (theList.isEmpty()) {
			throw new NoSuchElementException("LinkedList Vacia");
		}
		if (hasNext()) {
			return current.element;
		} else {
			return null;
		}
	}

}
