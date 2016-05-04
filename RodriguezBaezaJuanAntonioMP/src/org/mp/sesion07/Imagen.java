package org.mp.sesion07;

import java.util.ArrayList;


/**
 * Class Imagen. It allows you to instantiate and manipulate a binary image 
 * data and bands.
 * @author Juan A. Rodríguez Baeza
 * @version 0.1 02/06/2015
 *
 */
public class Imagen {
	
	/**
	 * Attributes
	 * formatoImagen	-> object image format
	 * bandas			-> object image bands
	 * lineas			-> lines of the object image
	 * columnas			-> object image columns
	 */
	private String formatoImagen;
	private ArrayList<BandaInt> bandas;
	private int lineas;
	private int columnas;

	/**
	 * Instance a new image.
	 * 
	 * @param lineas number of lines of the bands
	 * @param columnas number of columns in the bands
	 * @param formatoImagen image format
	 */
	public Imagen(int lineas, int columnas, String formatoImagen) {
		this.lineas = lineas;
		this.columnas = columnas;
		this.formatoImagen = formatoImagen;
		bandas = new ArrayList<BandaInt>();
	}

	/**
	 * Method getter data of a particular pixel
	 * 
	 * @param x column index of the bands
	 * @param y line index of the bands
	 * @return auxiliar data of a particular pixel in all bands
	 * @throws XYFueraImagenException check that the points x1, y1 
	 * not outside the range of the bands image
	 */
	public int[] getDatosPixel(int x, int y) throws XYFueraImagenException {
		if (x < 0 || y < 0) {
			throw new XYFueraImagenException("Pixeles fuera de la imagen");
		} else if (x >= lineas || y >= columnas) {
			throw new XYFueraImagenException("Pixeles fuera de la imagen");
		}
		int[] auxiliar = new int[bandas.size()];
		for (int i = 0; i < auxiliar.length; i++) {
			auxiliar[i] = bandas.get(i).getDatoXY(x, y);
		}
		return auxiliar;
	}

	/**
	 * Extracts data from the image bands from the points x1, y1 to x2, y2
	 * 
	 * @param x1 index starting columns bands to read
	 * @param y1 index starting lines to read bands
	 * @param x2 index end of the columns of the bands to read
	 * @param y2 index end of lines to read bands
	 * @return imagenAux image with all data points in the range x1, y1 - x2, y2 bands
	 * @throws XYFueraImagenException check that the points x1, y1 - x2, y2 not outside 
	 * 			the range of the bands image
	 */
	public Imagen extraerImagen(int x1, int y1, int x2, int y2)
			throws XYFueraImagenException {
		if (!XYValidar(x1, y1, x2, y2)) {
			throw new XYFueraImagenException("Pixeles fuera de la imagen");
		}
		int nLineas, nColumnas;
		Imagen imagenAux;
		BandaInt bandaTemp, bandaOrigen;
		nLineas = (y2 - y1) + 1;
		nColumnas = (x2 - x1) + 1;
		imagenAux = new Imagen(nLineas, nColumnas, this.formatoImagen);
		for (int i = 0; i < bandas.size(); i++) {
			bandaOrigen = bandas.get(i);
			bandaTemp = new BandaInt(bandaOrigen.getNombreBanda(), nColumnas,
					nLineas);

			for (int j = x1; j < nColumnas; j++) {
				for (int k = y1; k < nLineas; k++) {
					bandaTemp.setDatoXY(bandaOrigen.getDatoXY(x1, y1), x1, y1);
				}
			}
			imagenAux.añadirBanda(bandaTemp);
		}
		return imagenAux;
	}

	/**
	 * Add a band image
	 * 
	 * @param banda band to add
	 */
	public void añadirBanda(BandaInt banda) {
		bandas.add(banda);
	}

	/**
	 * Deletes an image band
	 * 
	 * @param i index of the band to remove
	 */
	public void eliminarBanda(int i) {
		bandas.remove(i);
	}

	/**
	 * Getter method of a band image
	 * 
	 * @param i band index
	 * @return image band with index i
	 */
	public BandaInt getBanda(int i) {
		return bandas.get(i);
	}

	/**
	 * Getter method for all bands image
	 * 
	 * @return bandas All bands image
	 */
	public ArrayList<BandaInt> getBandas() {
		return bandas;
	}

	/**
	 * Getter method of the number of bands of image
	 * 
	 * @return number of bands
	 */
	public int getNumeroBandas() {
		return bandas.size();
	}

	/**
	 * Getter method of the number of lines of image bands
	 * 
	 * @return lineas number of lines
	 */
	public int getLineas() {
		return lineas;
	}

	/**
	 * Getter method the number of columns of image bands
	 * 
	 * @return columnas number of columns
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * Getter method of image format
	 * 
	 * @return formatoImagen image format
	 */
	public String getFormatoImagen() {
		return formatoImagen;
	}

	/**
	 * Method setter image format
	 * 
	 * @param formatoImagen new image format
	 */
	public void setFormatoImagen(String formatoImagen) {
		this.formatoImagen = formatoImagen;
	}

	/**
	 * Setter method bands image
	 * 
	 * @param bandas new bands
	 */
	public void setBandas(ArrayList<BandaInt> bandas) {
		this.bandas = bandas;
	}

	/**
	 * Validates the range of points x1, y1 - x2, y2 bands image
	 * 
	 * @param x1 index starting columns bands
	 * @param y1 index starting lines of the bands
	 * @param x2 index end of the columns of the bands
	 * @param y2 index end of lines of the bands
	 * @return true en caso de ser un rango correcto, false en caso contrario
	 */
	private boolean XYValidar(int x1, int y1, int x2, int y2) {
		if (x1 < 0 || y1 < 0) {
			return false;
		} else if (x2 >= columnas || y2 >= lineas) {
			return false;
		} else if (x1 >= columnas || y2 >= lineas) {
			return false;
		} else {
			return true;
		}
	}
}
