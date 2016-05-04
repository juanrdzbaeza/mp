package org.mp.sesion06;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/**
 * Utility Class Files. Copy files, get a list of "directory/file" 
 * (recursively) in a directory and compress a file.
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 *
 */
@SuppressWarnings("rawtypes")
public class UtilidadArchivos {

	/**
	 * Attributes
	 * lista Object "ArrayList" of Java.util
	 */
	private ArrayList lista;

	/**
	 * Constructor of the class
	 */
	public UtilidadArchivos(){
		this.lista = new ArrayList();
	}

	/**
	 * Static method "copiar". Copy the source file to the specified destination
	 * @param origen Source file copying
	 * @param destino Path where the copy of the file will be stored.
	 * @throws IOException source file could not be found
	 */
	public static void copiar(File origen, File destino)throws IOException{
		if (!origen.exists()){
			throw new IOException("Archivo origen no encontrado");
		}
		InputStream leerRuta		= new FileInputStream(origen);
		OutputStream escribirRuta	= new FileOutputStream(destino);
		byte[] buffer = new byte[1024];
		int len;
		while ((len = leerRuta.read(buffer)) > 0) {
			escribirRuta.write(buffer, 0, len);
		}
		leerRuta.close();
		escribirRuta.close();
	}

	/**
	 * Method "listarDirectoriosArchivos". Gets the files/directories.
	 * in one direction or path through the private method "DirectoriosArchivosRec".
	 * @param ruta File with the address to list your files/directories.
	 * @return lista All files/directories "path"
	 */
	public ArrayList listarDirectoriosArchivos(File ruta){
		this.lista.clear();
		listarDirectoriosArchivosRec(ruta);
		return lista;
	}

	/**
	 * Private method that adds a file/directory to the list, in case of 
	 * this method runs directory to add all the elements of that directory 
	 * recursively.
	 * 
	 * @param ruta the address file to list files/directories.
	 */
	private void listarDirectoriosArchivosRec(File ruta){
		lista.add(ruta);
		if (ruta.isDirectory()) {
			String[] contenido = ruta.list();
			for (int i = 0; i < contenido.length; i++) {
				listarDirectoriosArchivosRec(new File(ruta, contenido[i]));
			}
		}
	}

	/**
	 * Method to compress a file, specify the file name to be compressed, 
	 * the way out and the final name of the archive.
	 * @param ruta To compress file or directory
	 * @param caminoSalida Output path to save the archive
	 * @param nombreArchivo Archive name
	 */
	public void zip(File ruta, String caminoSalida, String nombreArchivo){
		ArrayList elementos = listarDirectoriosArchivos(ruta);
		String salidaZip = caminoSalida + File.separator + nombreArchivo;
		byte buffer[] = new byte[1024];

		try {
			ZipOutputStream out = new ZipOutputStream(new FileOutputStream(salidaZip));
			for (int i = 0; i < lista.size(); i++) {
				File aux = (File) lista.get(i);
				if (aux.isFile()) {
					FileInputStream in = new FileInputStream(
							aux.getAbsolutePath());
					out.putNextEntry(new ZipEntry(aux.getAbsolutePath()));
					int len;
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					out.closeEntry();
					in.close();
				}
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}