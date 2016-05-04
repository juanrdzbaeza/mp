package org.mp.sesion04;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> stack = new StackLinkedListApi<Integer>();
		
		for (int i=0;i<20;i++)
			stack.push((Integer)i);
		
		System.out.println("Contenido Pila");
		System.out.println("Tamano Pila: " + stack.size());
		
		try{
			for (;;)
				System.out.print(" " + stack.peekAndPop());
		}catch (Exception e){	
		}
	}
}

