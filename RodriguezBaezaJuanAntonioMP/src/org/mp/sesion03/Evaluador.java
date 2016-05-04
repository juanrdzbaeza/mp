package org.mp.sesion03;

/**
 * 
 * @author Juan
 *
 */

public class Evaluador {

	StackLinkedList<String> pila;

	public Evaluador() {
		pila = new StackLinkedList<String>();
	}

	public String[] parser(String cadena) {
		return cadena.split(" ");
	}

	public int postfija(String[] s) {

		for (int i = 0; i < s.length; i++) {
			//String current = s[i];
			char c = s[i].charAt(0);
			if (Character.isDigit(c)) {
				pila.push(s[i]);
			} else {
				try {
					int temp2 = Integer.parseInt(pila.peekAndPop());
					int temp1 = Integer.parseInt(pila.peekAndPop());
					pila.push(operacion(temp1, temp2, s[i])+"");
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (EmptyStackException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			return Integer.parseInt(pila.peek());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
		return 0;
	}
	private static int operacion(int numero1, int numero2, String operador) {
		int resultado = 0;
		if (operador.equals("+"))
			return (numero1 + numero2);
		else if (operador.equals("-"))
			return (numero1 - numero2);
		else if (operador.equals("*"))
			return (numero1 * numero2);
		else if (operador.equals("/"))
			return (numero1 / numero2);
		else if (operador.equals("^")) {
			resultado = 1;
			for (int i = 0; i < numero2; i++)
				resultado *= numero1;
		}
		return resultado;
	}

}
