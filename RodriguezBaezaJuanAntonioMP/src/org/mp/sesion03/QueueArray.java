package org.mp.sesion03;

/**
 * Class for creating and managing queue of objects in arrays.
 * This class implements the interface Queue. 
 * Queues will be of generic objects "T"
 * 
 * @author Juan Antonio Rodríguez Baeza
 * @version 0.1 18/03/2015
 * @param <T> General object to parameterize
 */

public class QueueArray<T> implements Queue<T> {
	
	/**
	 * Attributes for the queue:
	 *	1) the array, container
	 *	2) queue length, number of elements
	 *	3) the first of the queue, marks the first element
	 *	4) the last of the queue, marks the last element
	 *	5) length of the array
	 */
	private T[] arrayCola;
	private int longitudDeLaCola;
	private int primeroDeLaCola;
	private int ultimoDeLaCola;
	static int longitudDelArray;
	
	/**
	 * Constructor for class, it generates by default one array type "T"
	 * with a defined size, place the first of the queue to 0, 
	 * the last of the queue to -1, the length of the queue to 0
	 * and the length of the array.
	 */
	public QueueArray(){
		this.arrayCola				= (T[]) new Object[5];	//fila
		this.primeroDeLaCola 		= 0;					//primero de la fila
		this.ultimoDeLaCola			= -1;					//último de la fila
		this.longitudDeLaCola		= 0;					//tamaño de la fila
		this.longitudDelArray		= arrayCola.length;		//tamaño del array
	}

	/**
	 * Method to add an element (x) always type "T" (parameterized),
	 * first check the queue status by calling the method ensureCapacity()
	 * @param x object, heir heir of the class Queue
	 */
	@Override
	public void addLast(T x) {
		ensureCapacity();
		if(this.ultimoDeLaCola == this.longitudDelArray-1){
			for(int i = 0; i<this.longitudDelArray; i++){
				if(this.arrayCola[i] == null){
					this.ultimoDeLaCola = i;
					this.arrayCola[ultimoDeLaCola] = x; //x pide la vez
					this.longitudDeLaCola++;
					break;
				}
			}
		}else{
			this.ultimoDeLaCola++;
			this.arrayCola[ultimoDeLaCola] = x; //x pide la vez
			this.longitudDeLaCola++;
		}
		
	}

	/**
	 * Method for checking the status of the queue, if it's full,
	 * create a new queue with twice the capacity and
	 * put each item in place appropriate
	 */
	private void ensureCapacity() {
		if (this.longitudDeLaCola == this.longitudDelArray){
			T[] colaAuxiliar = (T[]) new Object[longitudDelArray*2];
			for (int i = 0; i < longitudDelArray; i++,primeroDeLaCola=increment(primeroDeLaCola)) {
				colaAuxiliar[i] = arrayCola[primeroDeLaCola];
			}
			arrayCola = colaAuxiliar;
			longitudDelArray = arrayCola.length;
		}
	}

	/**
	 * 
	 * @param x
	 * @return
	 */
	private int increment(int x){
		if (++x == arrayCola.length) {
			x = 0;
		}
		return x;
	}

	/**
	 * Method to watch the first element of the queue. Check if it is empty and generates an exception
	 * @return element returns the element
	 * @throws EmptyStackException returns "Cola Vacia"
	 */
	@Override
	public T getFirst() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Cola Vacia");
		}
		return arrayCola[primeroDeLaCola];
	}

	/**
	 * Method for moving an item from the queue. Check if it is empty and generates an exception
	 * @throws EmptyStackException returns "Cola Vacia"
	 * @return PrimeroDeLaCola the first of the queue.
	 */
	@Override
	public T removeFirst() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Cola Vacia");
		}
		longitudDeLaCola--;
		T PrimeroDeLaCola = arrayCola[primeroDeLaCola];
		arrayCola[primeroDeLaCola] = null;
		primeroDeLaCola++;
		return PrimeroDeLaCola;
	}

	/**
	 * Boolean method to see if the queue is empty.
	 * @return boolean longitudDeLaCola = 0?
	 */
	@Override
	public boolean isEmpty() {
		return (longitudDeLaCola == 0);
	}
 
	/**
	 * Method for emptying the queue
	 */
	@Override
	public void clear() {
		this.primeroDeLaCola	= -1;
		this.ultimoDeLaCola		= -1;
		this.longitudDeLaCola	= 0;
	}

	/**
	 * Method to determine the size of the stack
	 * @return longitudDeLaCola 
	 */
	@Override
	public int size() {
		return this.longitudDeLaCola;
	}

	/**
	 * Method to watch the position of the last element of the queue.
	 * @return quienDaLavez position of the last
	 */
	public Integer getLastQueue(){
		int quienDaLavez = this.ultimoDeLaCola;
		return quienDaLavez;
	}

	/**
	 * Method to watch the position of the first element of the queue.
	 * @return quienVa position of the first
	 * @throws EmptyQueueException "Cola Vacia"
	 */
	public Integer getFirstQueue(){
		int quienVa = this.primeroDeLaCola;
		return quienVa;
	}
	
	public T[] getarrayCola(){
		return arrayCola;
		
	}

}
