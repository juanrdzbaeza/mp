package org.mp.sesion04;


/**
 * Clase que genera una Cola sobre una LinkedList
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 * @param <T> Tipo generico
 */
public class QueueLinkedListApi<T> implements Queue<T> {
	/**
	 * atributos
	 */
	private java.util.LinkedList<T> cola;
	
	/**
	 * constructor
	 * 
	 */
	public QueueLinkedListApi(){
		cola = new java.util.LinkedList<T>();
	}

	/**
	 * Inserts a new item in the queue.
	 */
	@Override
	public void addLast(T x) {
		cola.addLast(x);		
	}

	/**
	 * Returns the first inserted item in the queue. Does not alter the queue.
	 * 
	 * @return Returns the first inserted item in the queue.
	 * 
	 * @throws EmptyQueueException if the queue is empty.
	 */
	@Override
	public T getFirst() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Cola Vacia");
		}
		return cola.getFirst();
	}
	
	/** 
	 * Returns and removes the inserted first element in the queue. Does not alter the queue.
	 * 
	 * @return Returns the first inserted item in the queue.
	 * 
	 * @throws EmptyQueueException if the queue is empty.
	 */
	@Override
	public T removeFirst() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Cola Vacia");
		}
		return cola.pollFirst();
	}

	/** 
	 * Check if the queue is logically empty.
	 * 
	 * @return true if empty, false if it is full.
	 * 
	 */
	@Override
	public boolean isEmpty() {
		return cola.isEmpty();
	}

	/** 
	 * Makes the queue empty.
	 * 
	 */
	@Override
	public void clear() {
		cola.clear();		
	}

	/** 
	 * 
	 * @return Returns the size of the queue
	 *  
	 */
	@Override
	public int size() {
		return cola.size();
	}
}
