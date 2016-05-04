package org.mp.bloque1;

public class Punto {

	double x, y;
	
	public Punto(){
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public Punto (double ejex, double ejey){
		this.x = ejex;
		this.y = ejey;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public double distanciaAUnPunto(Punto p){
		return Math.sqrt(Math.pow(p.getX()+this.x, 2)+Math.pow(p.getY()+this.y , 2));
	}
	public double distanciaAlOrigen(){
		Punto origen = new Punto();
		return Math.sqrt(Math.pow(origen.getX()+this.x, 2)+Math.pow(origen.getY()+this.y , 2));
	}
	
	public String toString(){
		return "("+this.x+", "+this.y+")";
		
	}
}
