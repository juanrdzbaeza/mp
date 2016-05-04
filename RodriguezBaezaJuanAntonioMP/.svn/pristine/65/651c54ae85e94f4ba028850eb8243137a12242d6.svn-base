package org.mp.sesion04;

public class LinkedListTest {

	public static void main(String[] args) {
		List<Integer> laLista = new LinkedList<Integer>();
		ListIterator<Integer> iterador = 
			new LinkedListIterator<Integer>((LinkedList<Integer>) laLista);
		
		for (int i = 0; i < 10; i++)
			try{
				iterador.add(i); // Explicar la inserccion
			}catch (Exception e){
			}		
			try{
				System.out.println("Contenido de ListaEnlazada");
				for (iterador.first(); iterador.hasNext(); iterador.next())
					System.out.print(iterador.get().toString() + " ");
			}catch (NoSuchElementException e){
					
			}
	}
}
