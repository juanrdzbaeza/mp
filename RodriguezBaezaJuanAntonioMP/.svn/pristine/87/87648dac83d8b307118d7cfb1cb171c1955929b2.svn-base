package org.mp.sesion04;

public class LinkedListSortedTest {

	public static void main(String[] args) {
		List<Integer> laLista = new LinkedList<Integer>();
		ListIterator<Integer> iteradorOrdenado = new 
				LinkedListIteratorSorted<Integer>((LinkedList<Integer>) laLista);
		
		for (int i = 0; i < 15; i++)
			try{
				iteradorOrdenado.add((int)Math.round(Math.random() * 100));
			}catch (Exception e){
			}		
			
		
		System.out.println("Contenido de ListaEnlazada");
		try{
			for (iteradorOrdenado.first(); iteradorOrdenado.hasNext(); 
				iteradorOrdenado.next())
					System.out.print(iteradorOrdenado.get().toString() + " ");
		}catch (NoSuchElementException e){
						
		}
	}
}
