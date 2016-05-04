package org.mp.sesion03;

/**
 * Class for creating and managing queue of objects with linked lists.
 * This class implements the interface Queue.
 * Queues will be of generic objects "T"
 * 
 * @author Juan Antonio Rodríguez Baeza
 * @version 0.1 18/03/2015
 * @param <T> General object to parameterize
 */

public class QueueLinkedList<T> implements Queue<T>{
	
	/**
	 * Attributes for the queue:
	 *	1) the first of the queue, marks the first element
	 *	2) the last of the queue, marks the last element
	 *	3) queue length, number of elements
	 */
	protected ListNode<T> primeroDeLaCola;
	protected ListNode<T> ultimoDeLaCola;
	protected int longitudDeLaCola;
	

	/**
	 * Constructor for class, generates the default reference
	 * to the first of the queue, pointing to null, the last of the queue,
	 * pointing to null, and the length of the stack 0
	 */
	public QueueLinkedList(){
		this.primeroDeLaCola	= null;
		this.ultimoDeLaCola		= null;
		this.longitudDeLaCola	= 0;		
	}

	/**
	 * Method for generating a new node to add to the final of the queue
	 */
	@Override
	public void addLast(T x) {
		if(isEmpty()){
			this.primeroDeLaCola = this.ultimoDeLaCola = new ListNode<T>(x);
			this.longitudDeLaCola++;
		}else{
			this.ultimoDeLaCola = this.ultimoDeLaCola.next = new ListNode<T>(x);
			this.longitudDeLaCola++;
		}
	}

	/**
	 * Method to watch the first element of the queue. Check if it is empty and generates an exception
	 * @return element returns the element
	 * @throws EmptyStackException returns "Cola Vacia"
	 */
	@Override
	public T getFirst() throws EmptyQueueException {
		if(isEmpty()){
			throw new EmptyQueueException("Cola Vacia");
		}else{
			return primeroDeLaCola.element;
		}
	}

	/**
	 * Method for moving the first node from the queue. Check if it is empty and generates an exception
	 * @throws EmptyStackException returns "Cola Vacia"
	 * @return PrimeroDeLaCola the first of the queue.
	 */
	@Override
	public T removeFirst() throws EmptyQueueException {
		if(isEmpty()){
			throw new EmptyQueueException("Cola Vacia");
		}
		T PrimeroDeLaCola = this.primeroDeLaCola.element;
		this.primeroDeLaCola = this.primeroDeLaCola.next;
		this.longitudDeLaCola--;
		return PrimeroDeLaCola;
	}

	/**
	 * Boolean method to see if the queue is empty.
	 * @return boolean longitudDeLaCola = 0?
	 */
	@Override
	public boolean isEmpty() {
		return (this.longitudDeLaCola == 0);
	}

	/**
	 * Method for emptying the stack
	 */
	@Override
	public void clear() {
		this.primeroDeLaCola	= null;
		this.ultimoDeLaCola		= null;
		this.longitudDeLaCola	= 0;
	}

	/**
	 * Method to determine the size of the stack
	 * @return longitudDeLaCola.
	 */
	@Override
	public int size() {
		return this.longitudDeLaCola;
	}

}
