package org.mp.bloque1;

public class InstanciaPuntos {
	
	public static double mediaAritmetica(double[] vector){
		double media = 0;
		for (int i = 0; i < vector.length; i++) {
			media += vector[i];
		}
		return media;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Punto p1 = new Punto();
		Punto p2 = new Punto(5, 3);
		Punto p3 = new Punto(2, -1);
		double p4x, p4y;
		p4x = p3.getX() - p2.getX();
		p4y = p3.getY() - p2.getY();
		Punto p4 = new Punto(p4x, p4y);
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		System.out.println(p4.toString());
		System.out.println(p2.distanciaAUnPunto(p3));
		
		double [] vector = {-10, 5, 0, 7, 20};
		System.out.println(mediaAritmetica(vector));

	}

}
