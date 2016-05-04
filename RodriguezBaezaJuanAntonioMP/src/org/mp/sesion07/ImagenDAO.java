package org.mp.sesion07;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;


/**
 * ImagenDAO class.You can write a binary image BSQ in a text file and read 
 * the file and return a Picture
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 * 
 */
public class ImagenDAO {
	/**
	 * Write a text file header with the data needed to process the 
	 * image and calls the private method escribirBSQ () to write to disk
	 * 
	 * @param nombreArchivo header file name
	 * @param imagen write disk image
	 */
	public static void escribirArchivo(String nombreArchivo, Imagen imagen) {

		try {
			File f = new File(nombreArchivo);

			int posicionPunto = f.getName().indexOf(".");
			String ficheroB = f.getName().substring(0, posicionPunto) + ".dat";

			FileWriter fw = new FileWriter(nombreArchivo);
			BufferedWriter bw = new BufferedWriter(fw);	
			PrintWriter pw = new PrintWriter(bw);
			pw.println(ficheroB);
			pw.println(imagen.getFormatoImagen());
			pw.println(imagen.getNumeroBandas());
			String cabecera = "[";
			ArrayList<BandaInt> arrayList = imagen.getBandas();
			for (int i = 0; i < arrayList.size(); i++) {
				cabecera = cabecera + arrayList.get(i).toString() + ";";
			}
			cabecera = cabecera + "]";
			pw.println(cabecera);
			pw.println(imagen.getLineas());
			pw.println(imagen.getColumnas());
			pw.close();
			ficheroB = f.getParent() + File.separator + ficheroB;

			escribirBSQ(ficheroB, imagen);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Private method "escribirBSQ". It is responsible for writing the 
	 * image to disk in binary format.
	 * 
	 * @param nombreArchivo name and file path where the image will be written
	 * @param imagen write disk image
	 * 
	 */
	private static void escribirBSQ(String nombreArchivo, Imagen imagen) {
		try {
			// Creamos flujo de escritura
			FileOutputStream fos = new FileOutputStream(nombreArchivo);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream escribir = new DataOutputStream(bos);
			ArrayList<BandaInt> bandas = imagen.getBandas();

			ListIterator<BandaInt> iterador = bandas.listIterator();
			while (iterador.hasNext()) {

				BandaInt bandaTemp = iterador.next();

				for (int j = 0; j < imagen.getLineas(); j++) {
					for (int k = 0; k < imagen.getColumnas(); k++) {
						escribir.writeInt(bandaTemp.getDatoXY(k, j));
					}

				}
			}
			escribir.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Lee el fichero cabecera para obtener los datos y llama al metodo privado
	 * "leerBSQ()" para leer la imagen desde un fichero binario
	 * 
	 * @param nombreArchivo filename header text to read
	 * @return Read image file
	 */
	public static Imagen leerArchivo(String nombreArchivo) {
		String ficheroB, formato, temp;
		int nBandas;
		String[] bandas;
		int lineas, columnas;

		try {
			// Abrimos el archivo cabecera
			File file = new File(nombreArchivo);
			FileInputStream fstream = new FileInputStream(file);
			// Creamos el objeto de entrada
			DataInputStream entrada = new DataInputStream(fstream);
			// Creamos el buffer de lectura
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					entrada));
			// Leer el archivo linea por linea
			ficheroB = file.getParent() + File.separator + buffer.readLine();

			formato = buffer.readLine();
			nBandas = Integer.parseInt(buffer.readLine());
			temp = buffer.readLine();
			temp = temp.replace("[", "");
			temp = temp.replace("]", "");
			bandas = temp.split(";");
			lineas = Integer.parseInt(buffer.readLine());
			columnas = Integer.parseInt(buffer.readLine());
			entrada.close();
			return leerBSQ(ficheroB, new Imagen(lineas, columnas, formato),
					bandas);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	/**
	 * Private method that is responsible for reading the image from a 
	 * binary file and return.
	 * 
	 * @param nombreArchivo name of the binary file to read
	 * @param imagen Image instantiated with the number of lines, columns and image 
	 * 			format to read
	 * @param nbandas name bands of the image to read
	 * @return Image with all data and file read bands
	 */
	private static Imagen leerBSQ(String nombreArchivo, Imagen imagen,
			String[] nbandas) {

		// Creamos flujo de lectura
		File f = new File(nombreArchivo);
		DataInputStream leer;
		try {

			// Se abre el fichero a leer
			leer = new DataInputStream(new FileInputStream(f));

			for (int i = 0; i < nbandas.length; i++) {
				BandaInt banda = new BandaInt(nbandas[i], imagen.getColumnas(),
						imagen.getLineas());
				for (int j = 0; j < imagen.getLineas(); j++) {
					for (int k = 0; k < imagen.getColumnas(); k++) {
						banda.setDatoXY(leer.readInt(), j, k);
					}

				}
				imagen.añadirBanda(banda);
			}
			leer.close();

			return imagen;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
