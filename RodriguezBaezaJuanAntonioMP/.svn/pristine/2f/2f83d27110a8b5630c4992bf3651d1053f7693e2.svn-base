package org.mp.sesion08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.JButton;

/**
 * 
 * Graph class. Implements panel button to choose a file, if a graph paints txt file 
 * extension in the panel is chosen.
 * 
 * @author Juan Antonio Rodríguez Baeza
 * @version 0.1 02/06/2015
 * 
 */
public class Grafo extends JFrame {

	/**
	 * Attributes:
	 * elegir			->
	 * boton			->
	 * vertices			->
	 * aristas			->
	 * ficheroCorrecto	->
	 */
	private JFileChooser elegir;
	private JButton boton;
	private ArrayList<Point> vertices;
	private ArrayList<String> aristas;
	private boolean ficheroCorrecto;

	/**
	 * Class constructor initializes a graph
	 */
	public Grafo() {
		super();
		setTitle("Grafo");
		setSize(275, 275);
		setResizable(false);

		setLayout(new BorderLayout());
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		boton = new JButton("Seleccionar Archivo");
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				elegir = new JFileChooser();
				int opcion = elegir.showOpenDialog(elegir);

				// Si presionamos el boton ABRIR en un archivo llamamos al
				// metodo procesaGrafo y repaint
				if (opcion == JFileChooser.APPROVE_OPTION) {
					procesaGrafo(elegir.getSelectedFile().getPath());
					if (ficheroCorrecto) {
						repaintGrafo(getGraphics());
					} else {
						repaintError(getGraphics());
					}
				}
			}
		});

		add(boton, BorderLayout.NORTH);
		validate();

	}

	/**
	 * Check if the file has the expected content or not, and whether you
	 * have stored the vertices and edges
	 * 
	 * @param nombreArchivo file to process
	 */
	private void procesaGrafo(String nombreArchivo) {
		ficheroCorrecto = true;
		vertices = null;
		aristas = null;
		int nLineas = 0;
		String aux = "";
		try {
			File file = new File(nombreArchivo);
			FileInputStream fstream = new FileInputStream(file);
			// Creamos el objeto de entrada
			DataInputStream entrada = new DataInputStream(fstream);
			// Creamos el buffer de lectura
			BufferedReader buffer = new BufferedReader(new InputStreamReader(
					entrada));

			int posicionPunto = nombreArchivo.indexOf(".");

			// Comprobamos que la extension del archivo sea .txt
			if ((nombreArchivo.substring(posicionPunto, nombreArchivo.length()))
					.equals(".txt")) {

				// Obtenemos el numero de lineas, vertices y aristas del fichero
				while (buffer.readLine() != null) {
					nLineas++;
				}
				buffer.close();
				fstream = new FileInputStream(nombreArchivo);
				entrada = new DataInputStream(fstream);
				buffer = new BufferedReader(new InputStreamReader(entrada));

				aux = buffer.readLine();
				// Comprobamos 1ª Fichero grafo
				if (!aux.equals("Vertices")) {
					// System.out.println("Fichero grafo incorrecto");
					// System.exit(0);
					ficheroCorrecto = false;
				}
				vertices = new ArrayList<Point>();
				aux = buffer.readLine();
				String[] temp = aux.split(" ");
				for (int i = 0; i < (nLineas - 2) / 2; i++) {
					vertices.add(new Point(Integer.parseInt(temp[1]), Integer
							.parseInt(temp[2])));
					aux = buffer.readLine();
					temp = aux.split(" ");
				}
				if (!aux.equals("Aristas")) {
					// System.out.println("Fichero grafo incorrecto");
					// System.exit(0);

				}
				aristas = new ArrayList<String>();
				aux = buffer.readLine();
				for (int i = 0; i < (nLineas - 2) / 2; i++) {
					aristas.add(aux);
					aux = buffer.readLine();
				}

				buffer.close();
			} else {
				ficheroCorrecto = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * General Method paint
	 * @param g grafico 
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);

	}
	
	/**
	 * Painted on canvas / panel / window the graph stored in the text file previously read
	 * @param g graphic
	 */
	public void repaintGrafo(Graphics g) {
		paint(g);
		for (int i = 0; i < vertices.size(); i++) {
			Point temp = vertices.get(i);
			g.setColor(Color.black);
			g.fillOval(temp.x, temp.y + 50, 20, 20);
			g.drawString("" + i, temp.x - 3, temp.y + 45);
		}

		for (int i = 0; i < aristas.size(); i++) {
			String[] aux = aristas.get(i).split(" ");

			for (int j = 1; j < aux.length; j++) {
				g.drawLine(vertices.get(Integer.parseInt(aux[0])).x + 10,
						vertices.get(Integer.parseInt(aux[0])).y + 60,
						vertices.get(Integer.parseInt(aux[j])).x + 10,
						vertices.get(Integer.parseInt(aux[j])).y + 60);
			}
		}

	}
	/**
	 * Painted on canvas / panel / window an error message if the file is incorrect
	 * @param g graphic
	 */
	public void repaintError(Graphics g) {
		paint(g);

		g.setColor(Color.red);
		g.drawString("Fichero GRAFO incorrecto", (getWidth() / 2) - 60,
				getHeight() / 2);

	}
	/**
	 * General main method that launches the application
	 * @param args
	 */
	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		grafo.setVisible(true);
	}

}
