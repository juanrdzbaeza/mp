package org.mp.sesion07;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Class "ResidenciaSER". Save a residence disk, or rebuild it from a file, 
 * using the Object serialization.
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 *
 */
public class ResidenciaSER implements DataAccessObject {

	/**
	 * Attribute:
	 * nombreArchivo -> file name
	 */
	private String nombreArchivo;

	/**
	 * Class constructor. Instance a new ResdienciaSER
	 * 
	 * @param nombreArchivo name of the file will be saved or will read a residence
	 */
	public ResidenciaSER(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	/**
	 * File read from a residence, it reconstructs and returns.
	 * 
	 * @return residencia reconstructed
	 */
	@Override
	public Object leer() {
		Residencia residencia = null;
		File f = new File(nombreArchivo);
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			residencia = (Residencia) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return residencia;
	}

	/**
	 * Serializes the object passed as a parameter to a disk file.
	 * 
	 * @param object serialized object
	 */
	@Override
	public void escribir(Object object) {
		Residencia residencia = (Residencia) object;
		File f = new File(nombreArchivo);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(residencia);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
