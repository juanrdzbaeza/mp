package org.mp.sesion07;

/**
 * Class "ResidenciaDAOFactory". Reconstructs a residence by a 
 * serialized binary file, or by a xml file.
 * 
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 *
 */
public class ResidenciaDAOFactory {
	
	/**
	 * Attribute
	 * nombreArchivo -> file name
	 */
	protected String nombreArchivo;

	/**
	 * Static method that returns an object type or ResidenciaXML ResidenciaSER
	 * 
	 * @param nombreArchivo File name and path of the residence data 
	 * 				are stored where rebuild
	 * @param tipo type of reconstruction to be done, serializable or XML.
	 * @return Object "ResidenciaSER" or "ResidenciaXML" prepared to rebuild 
	 * 			homes or save to / from file
	 */
	public static DataAccessObject createResidenciaDAOFactory(
			String nombreArchivo, String tipo) {

		DataAccessObject dao = null;
		if (tipo.equals("ser")) {
			dao = new ResidenciaSER(nombreArchivo);
		}

		if (tipo.equals("xml")) {
			dao = new ResidenciaXML(nombreArchivo);
		}
		return dao;
	}

	/**
	 * Getter to return the name of the file
	 * 
	 * @return nombreArchivo file name
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	/**
	 * Setter to change the file name
	 * 
	 * @param nombreArchivo new name
	 */
	public void setNombreArchivo(String nuevoNombreArchivo) {
		this.nombreArchivo = nuevoNombreArchivo;
	}

}
