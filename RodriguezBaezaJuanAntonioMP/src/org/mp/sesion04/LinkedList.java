package org.mp.sesion04;

/**
 * Class LinkedList for make linked list
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 * @param <T> Generic tipe
 */
public class LinkedList<T> implements List<T> {
	/**
	 * Attribute
	 * the headNode
	 */
	protected ListNode<T> headNode;
	
	/**
	 * Constructor for the class
	 */
	public LinkedList(){
		this.headNode = new ListNode(null);
	}
	/**
	 * boolean method for know if the linked list is empty
	 * @return null true or false
	 */
	@Override
	public boolean isEmpty() {
		return this.headNode.next == null;
	}

	/**
	 * void method for clear the linked list
	 */
	@Override
	public void clear() {
		this.headNode.next = null;
		
	}

}
