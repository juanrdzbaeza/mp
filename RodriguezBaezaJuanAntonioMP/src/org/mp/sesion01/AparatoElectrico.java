package org.mp.sesion01;

public class AparatoElectrico {
	private int potencia;
	private boolean estado;
	private static int potenciaTotal = 0;
	
	public AparatoElectrico(int potencia){
		this.potencia	= potencia;
		this.estado		= false;//por defecto el aparato esta apagado
	}//constructor de la clase

	public static int getConsumoTotal() {
		return potenciaTotal;
	}//devuelve el consumo total de todos los aparatos eléctricos

	public int getConsumoAparato() {
		return (this.estado)?this.potencia:0;
	} /*
	  * devuelve el consumo de un aparato concreto 
	  * teniendo en cuenta si esta encendido o apagado
	  * en cuyo caso devuelve 0.
	  */
	
	public void clic(){
		this.estado = !this.estado;//interruptor
		potenciaTotal += (this.estado)?this.potencia:-this.potencia;
	}/*
	  * enciende o apaga el aparato, en caso de encenderlo
	  * suma su potencia a la potencia total
	  */
	
	
	@Override
	public String toString(){
		return this.potencia + ((this.estado)?"(On)":"(Off)");
	}

}//cierre de la clase AparatoElectrico
