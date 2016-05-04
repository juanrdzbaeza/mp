package org.mp.sesion03;

/**
 * Class for creating and managing stacks of objects in arrays.
 * This class implements the interface Stack. 
 * Stacks will be of generic objects "T"
 * 
 * @author Juan Antonio Rodríguez Baeza
 * @version 0.1 18/03/2015
 * @param <T> General object to parameterize
 */

public class StackArray<T> implements Stack<T>{
	
	/**
	 * Attributes for the stack:
	 *	1) the array, container
	 *	2) the top of the stack, marks the last element
	 *	3) stack length, number of elements
	 */
	private T[] arrayPila;
	private int topOfStack;
	private int longitud;

	/**
	 * Constructor for class, it generates by default one array type "T"
	 * with a defined size, place the top of the stack to -1, and the length to 0
	 */
	public StackArray(){
		this.arrayPila = (T[]) new Object[10];
		this.topOfStack = -1;
		this.longitud = 0;
	}
	
	/**
	 * Method to add an element (x) always type "T" (parameterized),
	 * first check the stack status by calling the method ensureCapacity()
	 * @param x object, heir of the class Stack
	 */
	@Override
	public void push(T x) {
		ensureCapacity();
		arrayPila[++topOfStack] = x;			//meto un elemento
		longitud++;
	}

	/**
	 * Method for checking the status of the stack, if it's full,
	 * create a new stack with twice the capacity and
	 * put each item in place appropriate
	 */
	private void ensureCapacity() {
		if(this.topOfStack+1 == this.arrayPila.length){
			T [] auxiliar = (T[]) new Object[arrayPila.length * 2];	//nueva pila
			for(int i=0; i<arrayPila.length; i++){					//lleno la pila nueva con
				auxiliar[i] = arrayPila[i];							//los elementos de
			}														//la pila antigua
			arrayPila = auxiliar;
			}		
	}


	/**
	 * Method for moving an item from the stack. Check if it is empty and generates an exception
	 * @throws EmptyStackException returns "Pila Vacia"
	 */
	@Override
	public void pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Pila Vacia");	//Pila Vacia
		}
		topOfStack--;			//saco el elemento sin mostrarlo
		longitud--;
	}

	/**
	 * Method to watch the last element of the stack. Check if it is empty and generates an exception
	 * @return element returns the element
	 * @throws EmptyStackException returns "Pila Vacia"
	 */
	@Override
	public T peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Pila Vacia");
		}
		T visto = arrayPila[topOfStack];
		return visto;			//lo veo pero no lo saco
	}

	/**
	 * Method to watch and moving the last element of the stack. Check if it is empty and generates an exception
	 * @return element returns the element
	 * @throws EmptyStackException returns "Pila Vacia"
	 */
	@Override
	public T peekAndPop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Pila Vacia");
		}
		T visto = (T) arrayPila[topOfStack];
		topOfStack--;
		longitud--;
		return visto;			//lo veo y lo saco
	}

	/**
	 * Boolean method to see if the stack is empty.
	 * @return boolean topOfStack = -1?
	 */
	@Override
	public boolean isEmpty() {
		return (this.topOfStack == -1);
	}

	/**
	 * Method for emptying the stack
	 */
	@Override
	public void clear() {
		this.topOfStack = -1;
		this.longitud	= 0;		
	}

	/**
	 * Method to determine the size of the stack
	 * @return longitud
	 */
	@Override
	public int size() {
		return this.longitud;
	}

}
