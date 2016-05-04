package org.mp.sesion07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Class "ResidenciaXML". Stores and retrieves residences / from XML files
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 *
 */
public class ResidenciaXML implements DataAccessObject {

	/**
	 * Attributes:
	 * nombreArchivo	-> filename
	 * xs				-> instance of com.thoughtworks.xstream.XStream
	 */
	private String nombreArchivo;
	private XStream xs;

	/**
	 * Class Constructor. Instance of a ResidenciaXML
	 *  
	 * @param nombreArchivo file name by which it will read / writes a residence
	 */
	public ResidenciaXML(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
		xs = new XStream(new DomDriver("UTF-8"));
		xs.alias("residencia", Residencia.class);
		xs.alias("residente", Residente.class);
		xs.alias("reserva", Reserva.class);
		xs.alias("habitacion", Habitacion.class);

	}

	
	/**
	 * Public method "leer".File read from a residence, it reconstructs and returns.
	 * 
	 * @return residencia residence reconstructed from XML file
	 */
	@Override
	public Object leer() {
		return (Residencia) xs.fromXML(new File(nombreArchivo));
	}
	/**
	 * Public method "escribir". Write the object passed as a parameter to an 
	 * XML file on disk.
	 * 
	 * @param obj object to write to disk in XML file
	 */
	@Override
	public void escribir(Object obj) {
		FileOutputStream fs;
		try {
			fs = new FileOutputStream(nombreArchivo);
			xs.toXML(obj, fs);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}