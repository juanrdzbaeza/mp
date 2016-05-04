package org.mp.sesion01;

public class TestInstalacionElectrica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InstalacionElectrica casa = new InstalacionElectrica(2, 2);
		casa.generarEscenario();
		System.out.println(casa.compruebaConsumo());
		System.out.println("************************");
		System.out.println(casa.toString());
	}//cierre del main
}//cierre de la clase TestCacharro
