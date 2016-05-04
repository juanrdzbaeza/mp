package org.mp.bloque1;

import java.util.Scanner;

public class IgualesONo {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca el primer argumento");
		String argumento1 = entrada.next();
		System.out.println("Introduzca el primer argumento");
		String argumento2 = entrada.next();
		boolean iguales = (argumento1.equals(argumento2));
		
		if (iguales) {
			System.out.println("ambos argumentos son iguales");
		} else {
			System.out.println("los argumentos son distintos");
		}

	}

}
