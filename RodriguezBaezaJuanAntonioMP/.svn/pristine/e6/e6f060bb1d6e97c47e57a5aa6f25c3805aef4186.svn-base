package org.mp.sesion03;

/**
 * Class for creating and managing stacks of objects with linked lists.
 * This class implements the interface Stack.
 * Stacks will be of generic objects "T"
 * 
 * @author Juan Antonio Rodríguez Baeza
 * @version 0.1 18/03/2015
 * @param <T> General object to parameterize
 */

public class StackLinkedList<T> implements Stack<T> {
	
	/**
	 * Attributes for the battery (linked lists):
	 *	1) the top of the stack, reference to the last node
	 *	3) length of the pile, number of nodes
	 */
	private ListNode<T> topOfStack;
	private int longitud;
	
	/**
	 * Constructor for class, generates the default reference
	 * to the top of the stack, pointing to null,
	 * and the length of the stack 0
	 */
	public StackLinkedList(){
		this.topOfStack	= null;
		this.longitud	= 0;
	}
	
	/**
	 * Method for generating a new node to add to the top of the stack
	 */
	@Override
	public void push(T x) {
		topOfStack = new ListNode<T>(x, topOfStack);
		longitud++;		
	}

	/**
	 * Method for moving an node from the stack. Check if it is empty and generates an exception
	 * @throws EmptyStackException returns "Pila Vacia"
	 */
	@Override
	public void pop() throws EmptyStackException{
		if(isEmpty()){
			throw new EmptyStackException("Pila Vacia");
		}
		topOfStack = topOfStack.next;
		longitud--;		
	}

	/**
	 * Method to watch the last node of the stack. Check if it is empty and generates an exception
	 */
	@Override
	public T peek() throws EmptyStackException {
		if(isEmpty()){
			throw new EmptyStackException("Pila Vacia");
		}
		return topOfStack.element;
	}

	/**
	 * Method to watch and moving the last node of the stack. Check if it is empty and generates an exception
	 */
	@Override
	public T peekAndPop() throws EmptyStackException {
		if(isEmpty()){
			throw new EmptyStackException("Pila Vacia");
		}
		T visto = topOfStack.element;
		topOfStack = topOfStack.next;
		return visto;
	}

	/**
	 * Boolean method to see if the stack is empty.
	 * @return boolean topOfStack = null?
	 */
	@Override
	public boolean isEmpty() {
		return (topOfStack == null);
	}

	/**
	 * Method for emptying the stack
	 */
	@Override
	public void clear() {
		topOfStack = null;
	}

	/**
	 * Method to determine the size of the stack
	 * @return longitud 
	 */
	@Override
	public int size() {
		return longitud;
	}

}
