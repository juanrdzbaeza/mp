package org.mp.sesion04;


/**
 * Class StackLinkedListApi for make stacks with linked list
 *  
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 * @param <T> Generic tipe
 */

public class StackLinkedListApi<T> implements Stack<T> {

	/**
	 * Attributes:
	 * 
	 * stackLinkedListApi object linked list java api
	 */
	private java.util.LinkedList<T> stackLinkedListApi;
	
	/**
	 * constructor for the class
	 */
	public StackLinkedListApi(){
		stackLinkedListApi = new java.util.LinkedList<T>();
	}
	
	/**
	 * Inserts a new element on the stack
	 * @param x the item to insert
	 */
	@Override
	public void push(T x) {
		stackLinkedListApi.add(x);		
	}

	/**
	 * Removes the most recently inserted item
	 * @exception EmptyStackException if the battery is empty
	 */
	@Override
	public void pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Pila Vacia");
		}
		stackLinkedListApi.removeLast();		
	}

	/**
	 * Gets the most recently inserted element does not alter cell stack
	 * @return insert item
	 * @exception EmptyStackException If the Stack is empty
	 */
	@Override
	public T peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Pila Vacia");
		}
		return stackLinkedListApi.peekLast();
	}

	/**
	 * Returns and removes the element most recently inserted into stack
	 * 
	 * @return insert item
	 * 
	 * @throws EmptyStackException if the Stack is empty
	 */
	@Override
	public T peekAndPop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Pila Vacia");
		}
		return stackLinkedListApi.pollLast();
	}

	/**
	 * Check if the stack is empty
	 * 
	 * @return true if empty stack, and false if you have any item
	 */
	@Override
	public boolean isEmpty() {
		return stackLinkedListApi.isEmpty();
	}

	/**
	 * Puts a stack empty
	 */
	@Override
	public void clear() {
		stackLinkedListApi.clear();		
	}

	/**
	 * @return Stack size
	 */
	@Override
	public int size() {
		return stackLinkedListApi.size();
	}

}
