package org.mp.sesion04;

public class QueueTest {

	public static void main(String[] args) {
		Queue<Integer> queue = new QueueLinkedListApi<Integer>();
	
		for (int i = 0; i < 20; i++)
			queue.addLast((Integer)i);
				
		System.out.println("Contenido Cola");
		System.out.println("Tamano Cola: " + queue.size());
		
		try{
			for (;;)
				System.out.print(" " + queue.removeFirst());
		}catch (Exception e){	
		}
	}
}

