package org.mp.sesion01;

public class InstalacionElectrica {
	private AparatoElectrico[][] instalacion;

	public InstalacionElectrica(int dim1, int dim2){
		instalacion = new AparatoElectrico[dim1][dim2];
		for (int i = 0; i < dim1; i++) {
			for (int j = 0; j < dim2; j++) {
				AparatoElectrico cacharro = new AparatoElectrico((int) ((Math.random()*9001)+1000));
				instalacion[i][j] = cacharro;
			}//cierre del for interno
		}//cierre del for externo
	}//constructor de la clase
	
	public void generarEscenario(){
		for (int i = 0; i < instalacion.length; i++) {
			for (int j = 0; j < instalacion[i].length; j++) {
				if ((Math.random())<=0.7){
					instalacion[i][j].clic();
				}
			}//cierre del for interno
		}//cierre del for externo
	}//cierre del metodo generarEscenario
	
	public boolean compruebaConsumo(){
		int consumoDeAparatos = 0;
		for (int i = 0; i < instalacion.length; i++) {
			for (int j = 0; j < instalacion[i].length; j++) {
				consumoDeAparatos += instalacion[i][j].getConsumoAparato();
			}
		}
		return (AparatoElectrico.getConsumoTotal() == consumoDeAparatos);
	}//cierre del metodo compruebaConsumo
	
	@Override
	public String toString(){
		String impresion = "";
		for (int i = 0; i < instalacion.length; i++) {
			for (int j = 0; j < instalacion.length; j++) {
				impresion += instalacion[i][j].toString()+"\t";
			}
			impresion += "\n";
		}
		return impresion;
	}//cierre del metodo toString
}//cierre de la clase InstalacionElectrica
